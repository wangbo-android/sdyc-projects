package com.springboot2.important.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.springboot2.important.entity.People;
import java.io.IOException;


public class JsonCustomDeserialize extends JsonDeserializer<People> {

    @Override
    public People deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {

        JsonNode node = p.getCodec().readTree(p);
        String name = node.get("p-name").asText();
        People people = new People();
        people.setName(name);

        return people;
    }
}
