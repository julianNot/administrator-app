package edu.uptc.swii.administratorapp.application.port.output;

import edu.uptc.swii.administratorapp.domain.model.order.Order;
import edu.uptc.swii.administratorapp.domain.model.order.OrderId;
import edu.uptc.swii.administratorapp.domain.model.customer.CustomerId;
import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    Order save(Order order);
    Optional<Order> findById(OrderId orderId);
    List<Order> findByCustomerId(CustomerId customerId);
}
