package edu.uptc.swii.administratorapp.domain.service;

import edu.uptc.swii.administratorapp.domain.model.order.Order;
import edu.uptc.swii.administratorapp.domain.model.order.OrderStatus;
import edu.uptc.swii.administratorapp.domain.exception.OrderValidationException;

public class OrderValidationService {
    public void validateOrderForCreation(Order order) {
        if (order == null) {
            throw new OrderValidationException("Order cannot be null");
        }
        if (order.getStatus() != OrderStatus.RECEIVED) {
            throw new OrderValidationException("New orders must have RECEIVED status");
        }
    }

    public void validateStatusTransition(Order order, OrderStatus newStatus) {
        if (!order.getStatus().canTransitionTo(newStatus)) {
            throw new OrderValidationException(
                String.format("Invalid status transition from %s to %s", 
                            order.getStatus(), newStatus)
            );
        }
    }
}