package edu.uptc.swii.cqrscontroller.infrastructure.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.uptc.swii.cqrscontroller.model.Order;
import edu.uptc.swii.cqrscontroller.application.service.*;

@RestController
public class OrderController {
    

    private final OrderService orderService;


    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @PostMapping("/addorder")
    public String sendMessageOrder(@RequestBody Order order) {
        System.out.println("aaaaaaaaaaaaaaaaaa");
        orderService.addOrder(order);
        return order.toString();
    }


    @PostMapping("/updateorder")
    public String sendMessageUpdateOrder(@RequestBody Order order) {
        orderService.updateOrder(order);
        return order.toString();
    }
}
