package com.cache.mycache.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.io.UnsupportedEncodingException;

@Configuration
public class CacheConfig {

    @Value("${springext.cache.redis.topic:cache}")
    private String topicName;

    @Bean
    public RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
                                                   MessageListenerAdapter listenerAdapter){

        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(listenerAdapter,new PatternTopic(topicName));
        return container;
    }

    @Bean
    public TwoLevelCacheManager cacheManager(StringRedisTemplate redisTemplate){

        RedisCacheWriter writer = RedisCacheWriter.
                lockingRedisCacheWriter(redisTemplate.getConnectionFactory());

        RedisSerializationContext.SerializationPair pair =
                RedisSerializationContext.SerializationPair.
                        fromSerializer(new JdkSerializationRedisSerializer(this.
                                getClass().getClassLoader()));
        RedisCacheConfiguration config =
                RedisCacheConfiguration.
                        defaultCacheConfig().
                        serializeValuesWith(pair);
        TwoLevelCacheManager cacheManager =
                new TwoLevelCacheManager(redisTemplate,writer,config);
        return cacheManager;
    }

    @Bean
    public MessageListenerAdapter listenerAdapter(final TwoLevelCacheManager cacheManager){

        return new MessageListenerAdapter(new MessageListener() {
            @Override
            public void onMessage(Message message, byte[] bytes) {

                try{

                    String cacheName = new String(message.getBody(),"UTF-8");
                    cacheManager.receiver(cacheName);

                } catch (UnsupportedEncodingException e){

                    e.printStackTrace();
                }
            }
        });
    }
}
