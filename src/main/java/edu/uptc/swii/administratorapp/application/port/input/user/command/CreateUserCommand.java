package edu.uptc.swii.administratorapp.application.port.input.user.command;

public record CreateUserCommand(
    String customerId,
    String password
) {}