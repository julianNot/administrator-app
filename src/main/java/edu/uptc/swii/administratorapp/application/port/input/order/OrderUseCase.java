package edu.uptc.swii.administratorapp.application.port.input.order;


import edu.uptc.swii.administratorapp.application.port.input.order.command.CreateOrderCommand;
import edu.uptc.swii.administratorapp.application.port.input.order.command.UpdateOrderStatusCommand;
import edu.uptc.swii.administratorapp.application.port.input.order.query.FindOrdersByCustomerQuery;
import edu.uptc.swii.administratorapp.application.port.input.order.response.CreateOrderResponse;
import edu.uptc.swii.administratorapp.application.port.input.order.response.FindOrdersResponse;
import edu.uptc.swii.administratorapp.application.port.input.order.response.UpdateOrderStatusResponse;

public interface OrderUseCase {
    CreateOrderResponse createOrder(CreateOrderCommand command);
    UpdateOrderStatusResponse updateOrderStatus(UpdateOrderStatusCommand command);
    FindOrdersResponse findOrdersByCustomer(FindOrdersByCustomerQuery query);
}

