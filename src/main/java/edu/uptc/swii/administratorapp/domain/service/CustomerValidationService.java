package edu.uptc.swii.administratorapp.domain.service;

import edu.uptc.swii.administratorapp.domain.model.customer.Customer;
import edu.uptc.swii.administratorapp.domain.exception.CustomerValidationException;

public class CustomerValidationService {
    public void validateCustomerForCreation(Customer customer) {
        if (customer == null) {
            throw new CustomerValidationException("Customer cannot be null");
        }
        // Aquí irían validaciones adicionales específicas del dominio
    }
}

