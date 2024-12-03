package edu.uptc.swii.cqrsquery.infrastructure.adapter.output.kafka2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import edu.uptc.swii.cqrsquery.application.port.output.event.OrderEventConsumer;
import edu.uptc.swii.cqrsquery.application.service.OrderService;
import edu.uptc.swii.cqrsquery.domain.model.Order;
import edu.uptc.swii.cqrsquery.infrastructure.repository.mongoDb.OrderMongo;
import edu.uptc.swii.cqrsquery.infrastructure.utils.JsonUtils;

public class KafkaOrderEventConsumer implements OrderEventConsumer {
    @Autowired
    private OrderService orderService;

    @KafkaListener(topics = "add-order-topic", groupId = "order-group")
    public void addOrderConsume(String message) {
        message=message.replace("\\","");
        message=message.substring(1, message.length()-1);
        System.out.println("Add Order - Received Message: " + message);
        JsonUtils jsonUtils = new JsonUtils();
        OrderMongo savedOrder = jsonUtils.fromJson(message, OrderMongo.class);
        orderService.addOrder(savedOrder);

    }

    @KafkaListener(topics = "update-order-topic", groupId = "customer-group")
    public void updateOrderConsume(String message) {
        System.out.println("Update Order - Received Message: " + message);
        JsonUtils jsonUtils = new JsonUtils();
        Order savedOrder = jsonUtils.fromJson(message, Order.class);
        orderService.updateOrderStatus(savedOrder.getOrderId(),savedOrder.getStatus());
    }
}

