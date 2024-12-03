package edu.uptc.swii.cqrscontroller.application.port.in;

import edu.uptc.swii.cqrscontroller.model.Order;

public interface IOrderService {

    public Order addOrder(Order order);

    public Order updateOrder(Order order);
    
}
