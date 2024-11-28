package edu.uptc.swii.administratorapp.application.port.input.order.response;

public record CreateOrderResponse(
    String orderId,
    String customerId,
    String status,
    boolean success
) {}
