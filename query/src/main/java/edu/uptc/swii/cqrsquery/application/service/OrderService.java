package edu.uptc.swii.cqrsquery.application.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uptc.swii.cqrsquery.infrastructure.adapter.input.mongo.MongoCustomerRepository;
import edu.uptc.swii.cqrsquery.infrastructure.adapter.input.mongo.MongoOrderRepository;
import edu.uptc.swii.cqrsquery.infrastructure.repository.mongoDb.CustomerMongo;
import edu.uptc.swii.cqrsquery.infrastructure.repository.mongoDb.OrderMongo;

@Service
public class OrderService {
    @Autowired
    private final MongoOrderRepository orderRepository;


    public OrderService(MongoOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void addOrder(OrderMongo order){
        orderRepository.insert(order);        
    }

    public void updateOrderStatus(String orderId, String status){
        Optional<OrderMongo> optOrder = orderRepository.findById(orderId);
        OrderMongo updatedOrder = optOrder.get();
        updatedOrder.setStatus(status);
        orderRepository.save(updatedOrder);
    }
}
