package edu.uptc.swii.administratorapp.application.port.input.user.command;

public record AuthenticateUserCommand(
    String customerId,
    String password
) {}