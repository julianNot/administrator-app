package edu.uptc.swii.administratorapp.application.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import edu.uptc.swii.administratorapp.application.port.input.order.OrderUseCase;
import edu.uptc.swii.administratorapp.application.port.input.order.command.CreateOrderCommand;
import edu.uptc.swii.administratorapp.application.port.input.order.command.UpdateOrderStatusCommand;
import edu.uptc.swii.administratorapp.application.port.input.order.query.FindOrdersByCustomerQuery;
import edu.uptc.swii.administratorapp.application.port.input.order.response.CreateOrderResponse;
import edu.uptc.swii.administratorapp.application.port.input.order.response.FindOrdersResponse;
import edu.uptc.swii.administratorapp.application.port.input.order.response.UpdateOrderStatusResponse;
import edu.uptc.swii.administratorapp.application.port.output.CustomerRepository;
import edu.uptc.swii.administratorapp.application.port.output.OrderRepository;
import edu.uptc.swii.administratorapp.application.port.output.event.OrderEventPublisher;
import edu.uptc.swii.administratorapp.domain.model.customer.CustomerId;
import edu.uptc.swii.administratorapp.domain.model.order.Order;
import edu.uptc.swii.administratorapp.domain.model.order.OrderStatus;
import edu.uptc.swii.administratorapp.domain.service.OrderValidationService;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class OrderService implements OrderUseCase {
    private final OrderRepository orderRepository = null;
    private final CustomerRepository customerRepository = null;
    private final OrderEventPublisher eventPublisher = null;
    private final OrderValidationService validationService = null;

    @Override
    public CreateOrderResponse createOrder(CreateOrderCommand command) {
        // Verificar que existe el cliente
        CustomerId customerId = new CustomerId(command.customerId());
        if (customerRepository.findById(customerId).isEmpty()) {
            return new CreateOrderResponse(null, command.customerId(), null, false);
        }

        // Crear la orden usando el builder del dominio
        Order order = Order.builder()
            .id(UUID.randomUUID().toString())
            .customerId(command.customerId())
            .status(OrderStatus.RECEIVED)
            .build();

        // Validar la orden usando el servicio de dominio
        validationService.validateOrderForCreation(order);

        // Persistir y publicar evento
        Order savedOrder = orderRepository.save(order);
        eventPublisher.publishOrderCreated(savedOrder);

        return new CreateOrderResponse(
            savedOrder.getId().value(),
            savedOrder.getCustomerId().value(),
            savedOrder.getStatus().name(),
            true
        );
    }

    @Override
    public UpdateOrderStatusResponse updateOrderStatus(UpdateOrderStatusCommand command) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateOrderStatus'");
    }

    @Override
    public FindOrdersResponse findOrdersByCustomer(FindOrdersByCustomerQuery query) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findOrdersByCustomer'");
    }

    // Otros métodos del OrderUseCase...
}