package edu.uptc.swii.cqrscontroller.application.service;

import org.springframework.stereotype.Service;

import edu.uptc.swii.cqrscontroller.model.Order;
import edu.uptc.swii.cqrscontroller.application.port.in.IOrderService;
import edu.uptc.swii.cqrscontroller.infrastructure.repository.*;

@Service
public class OrderService implements IOrderService {
     private final OrderRepository orderRepository;
    private final OrderEventProducer orderEventProducer;
    private final String ADD_ORDER_TOPIC = "add-order-topic";
    private final String UPDATE_ORDER_TOPIC = "update-order-topic";

     public OrderService(edu.uptc.swii.cqrscontroller.infrastructure.repository.OrderRepository orderRepository,
            OrderEventProducer orderEventProducer) {
        this.orderRepository = orderRepository;
        this.orderEventProducer = orderEventProducer;
    }


    public Order addOrder(Order order){
        Order savedOrder = orderRepository.save(order);
        orderEventProducer.sendMessage(ADD_ORDER_TOPIC,order);
        return savedOrder;
    }


    public Order updateOrder(Order order){
        Order savedOrder = orderRepository.save(order);
        orderEventProducer.sendMessage(UPDATE_ORDER_TOPIC,order);
        return savedOrder;
    }
}
