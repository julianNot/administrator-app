package edu.uptc.swii.administratorapp.application.port.input.customer.response;

public record CreateCustomerResponse(
    String customerId,
    boolean success
) {}
