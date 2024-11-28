package edu.uptc.swii.administratorapp.application.port.input.order.command;

public record UpdateOrderStatusCommand(
    String orderId,
    String status
) {}

