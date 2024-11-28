package edu.uptc.swii.administratorapp.application.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import edu.uptc.swii.administratorapp.application.port.input.user.UserUseCase;
import edu.uptc.swii.administratorapp.application.port.input.user.command.AuthenticateUserCommand;
import edu.uptc.swii.administratorapp.application.port.input.user.command.CreateUserCommand;
import edu.uptc.swii.administratorapp.application.port.input.user.response.AuthenticateUserResponse;
import edu.uptc.swii.administratorapp.application.port.input.user.response.CreateUserResponse;
import edu.uptc.swii.administratorapp.application.port.output.CustomerRepository;
import edu.uptc.swii.administratorapp.application.port.output.UserRepository;
import edu.uptc.swii.administratorapp.domain.exception.UserValidationException;
import edu.uptc.swii.administratorapp.domain.model.customer.CustomerId;
import edu.uptc.swii.administratorapp.domain.model.user.User;
import edu.uptc.swii.administratorapp.domain.service.UserValidationService;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService implements UserUseCase {

    private final UserRepository userRepository = null;
    private final CustomerRepository customerRepository = null;
    private final PasswordEncoder passwordEncoder = null;
    private final UserValidationService validationService = null;

    @Override
    public CreateUserResponse createUser(CreateUserCommand command) {
        try {
            // Verificar que existe el cliente
            CustomerId customerId = new CustomerId(command.customerId());
            if (customerRepository.findById(customerId).isEmpty()) {
                return CreateUserResponse.customerNotFound(command.customerId());
            }

            // Verificar si ya existe un usuario para este cliente
            if (userRepository.findByCustomerId(customerId).isPresent()) {
                return CreateUserResponse.userAlreadyExists(command.customerId());
            }

            // Crear el usuario usando el builder del dominio
            User user = User.builder()
                .id(UUID.randomUUID().toString())
                .customerId(command.customerId())
                //.password(passwordEncoder.encode())
                .build();

            // Validar el usuario
            try {
                validationService.validateUserForCreation(user);
            } catch (UserValidationException e) {
                return CreateUserResponse.validationError(
                    command.customerId(),
                    e.getMessage()
                );
            }

            // Persistir el usuario
            User savedUser = userRepository.save(user);

            return CreateUserResponse.success(
                savedUser.getId().value(),
                savedUser.getCustomerId().value()
            );

        } catch (Exception e) {
            return CreateUserResponse.error(
                command.customerId(),
                e.getMessage()
            );
        }
    }

    @Override
    public AuthenticateUserResponse authenticateUser(AuthenticateUserCommand command) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'authenticateUser'");
    }    
}