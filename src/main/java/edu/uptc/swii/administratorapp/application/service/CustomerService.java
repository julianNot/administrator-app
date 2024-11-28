package edu.uptc.swii.administratorapp.application.service;

import edu.uptc.swii.administratorapp.application.port.input.customer.CustomerUseCase;
import edu.uptc.swii.administratorapp.application.port.input.customer.command.CreateCustomerCommand;
import edu.uptc.swii.administratorapp.application.port.input.customer.command.UpdateCustomerCommand;
import edu.uptc.swii.administratorapp.application.port.input.customer.query.FindCustomerQuery;
import edu.uptc.swii.administratorapp.application.port.input.customer.response.CreateCustomerResponse;
import edu.uptc.swii.administratorapp.application.port.input.customer.response.FindCustomerResponse;
import edu.uptc.swii.administratorapp.application.port.input.customer.response.UpdateCustomerResponse;
import edu.uptc.swii.administratorapp.application.port.output.CustomerRepository;
import edu.uptc.swii.administratorapp.application.port.output.event.CustomerEventPublisher;
import edu.uptc.swii.administratorapp.domain.model.customer.*;
import edu.uptc.swii.administratorapp.domain.service.CustomerValidationService;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerService implements CustomerUseCase {
    private final CustomerRepository customerRepository;
    private final CustomerEventPublisher eventPublisher;
    private final CustomerValidationService validationService;

    public CustomerService(
        CustomerRepository customerRepository,
        CustomerEventPublisher eventPublisher,
        CustomerValidationService validationService
    ) {
        this.customerRepository = customerRepository;
        this.eventPublisher = eventPublisher;
        this.validationService = validationService;
    }

    @Override
    public CreateCustomerResponse createCustomer(CreateCustomerCommand command) {
        // Verificar si el cliente ya existe
        if (customerRepository.existsByDocument(command.document())) {
            return new CreateCustomerResponse(null, false);
        }

        // Crear el cliente usando el builder del dominio
        Customer customer = Customer.builder()
            .id(UUID.randomUUID().toString())
            .document(command.document())
            .name(command.firstName(), command.lastName())
            .address(command.street(), command.city(), command.country())
            .phone(command.phone())
            .email(command.email())
            .build();

        // Validar el cliente usando el servicio de dominio
        validationService.validateCustomerForCreation(customer);

        // Persistir y publicar evento
        Customer savedCustomer = customerRepository.save(customer);
        eventPublisher.publishCustomerCreated(savedCustomer);

        return new CreateCustomerResponse(savedCustomer.getId().value(), true);
    }

    @Override
    public FindCustomerResponse findCustomerById(FindCustomerQuery query) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findCustomerById'");
    }

    @Override
    public UpdateCustomerResponse updateCustomer(UpdateCustomerCommand command) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateCustomer'");
    }

    // Otros métodos del CustomerUseCase...
}
