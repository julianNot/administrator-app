package edu.uptc.swii.administratorapp.application.port.input.customer;

import edu.uptc.swii.administratorapp.application.port.input.customer.command.CreateCustomerCommand;
import edu.uptc.swii.administratorapp.application.port.input.customer.command.UpdateCustomerCommand;
import edu.uptc.swii.administratorapp.application.port.input.customer.query.FindCustomerQuery;
import edu.uptc.swii.administratorapp.application.port.input.customer.response.CreateCustomerResponse;
import edu.uptc.swii.administratorapp.application.port.input.customer.response.FindCustomerResponse;
import edu.uptc.swii.administratorapp.application.port.input.customer.response.UpdateCustomerResponse;

public interface CustomerUseCase {
    CreateCustomerResponse createCustomer(CreateCustomerCommand command);
    FindCustomerResponse findCustomerById(FindCustomerQuery query);
    UpdateCustomerResponse updateCustomer(UpdateCustomerCommand command);
}
