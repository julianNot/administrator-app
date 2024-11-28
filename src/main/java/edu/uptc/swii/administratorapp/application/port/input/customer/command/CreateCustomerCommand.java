package edu.uptc.swii.administratorapp.application.port.input.customer.command;

public record CreateCustomerCommand(
    String document,
    String firstName,
    String lastName,
    String street,
    String city,
    String country,
    String phone,
    String email
) {}
