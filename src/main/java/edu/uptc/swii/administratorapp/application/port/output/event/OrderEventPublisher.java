package edu.uptc.swii.administratorapp.application.port.output.event;

import edu.uptc.swii.administratorapp.domain.model.order.Order;

public interface OrderEventPublisher {
    void publishOrderCreated(Order order);
    void publishOrderStatusUpdated(Order order);
}
