package com.rest.client;

import com.rest.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping(value = "/test")
public class RestClientTestController {

    @Value(value = "${api.order}")
    private String base;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @GetMapping(path = "/get/{orderId}")
    public @ResponseBody Order testGetOrder(@PathVariable String orderId){

        RestTemplate restTemplate = restTemplateBuilder.build();
        String uri = base + "/order/{orderId}";

        Order order = restTemplate.getForObject(uri,Order.class,orderId);

        return order;
    }

    @GetMapping(path = "/list/{orderId}")
    public @ResponseBody List<Order> testListOrder(@PathVariable String orderId){

        RestTemplate restTemplate = restTemplateBuilder.build();
        String uri = base + "/order/{orderId}";

        ParameterizedTypeReference<List<Order>> typeRef =
                new ParameterizedTypeReference<List<Order>>() {
        };

        ResponseEntity<List<Order>> rs = restTemplate.exchange(uri, HttpMethod.GET,null,typeRef);

        List<Order> orders = rs.getBody();

        return orders;
    }
}
