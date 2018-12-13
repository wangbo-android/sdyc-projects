package com.rest.controller;


import com.rest.entity.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class ControllerRestStyle {

    @GetMapping(path = "/order/{orId}")
    public Order getOrder(@PathVariable int orId){

        Order order = new Order();
        order.setoId(orId);
        order.setInfos("就给客人进口国垃圾考虑");

        return order;
    }
}
