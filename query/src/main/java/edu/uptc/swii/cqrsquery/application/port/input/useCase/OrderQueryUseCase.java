package edu.uptc.swii.cqrsquery.application.port.input.useCase;

import edu.uptc.swii.cqrsquery.domain.model.Order;

public interface OrderQueryUseCase {
     public void addOrder(Order order);
    public void updateOrderStatus(String orderId, String status);
}
