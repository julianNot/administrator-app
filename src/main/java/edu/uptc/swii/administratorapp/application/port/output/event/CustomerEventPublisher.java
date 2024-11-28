package edu.uptc.swii.administratorapp.application.port.output.event;

import edu.uptc.swii.administratorapp.domain.model.customer.Customer;

public interface CustomerEventPublisher {
    void publishCustomerCreated(Customer customer);
    void publishCustomerUpdated(Customer customer);
}
