package edu.uptc.swii.administratorapp.application.port.input.user;


import edu.uptc.swii.administratorapp.application.port.input.user.command.CreateUserCommand;
import edu.uptc.swii.administratorapp.application.port.input.user.command.AuthenticateUserCommand;
import edu.uptc.swii.administratorapp.application.port.input.user.response.CreateUserResponse;
import edu.uptc.swii.administratorapp.application.port.input.user.response.AuthenticateUserResponse;

public interface UserUseCase {
    CreateUserResponse createUser(CreateUserCommand command);
    AuthenticateUserResponse authenticateUser(AuthenticateUserCommand command);
}
