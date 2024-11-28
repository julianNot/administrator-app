package edu.uptc.swii.administratorapp.application.port.input.customer.response;

public record FindCustomerResponse(
    String customerId,
    String document,
    String firstName,
    String lastName,
    String street,
    String city,
    String country,
    String phone,
    String email
) {}

