package edu.uptc.swii.cqrsquery.adapter.input.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.uptc.swii.cqrsquery.infrastructure.adapter.input.mongo.MongoOrderRepository;
import edu.uptc.swii.cqrsquery.infrastructure.repository.mongoDb.OrderMongo;

@RestController
public class OrderQueryController {

    private final MongoOrderRepository orderRepository;

    public OrderQueryController(MongoOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/findorderbycustomerid")
    public OrderMongo getCustomerById(@RequestParam String id) {
        return orderRepository.findByCustomerId(id).get();
    }
    
}
