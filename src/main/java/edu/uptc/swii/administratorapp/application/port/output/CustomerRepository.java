package edu.uptc.swii.administratorapp.application.port.output;

import edu.uptc.swii.administratorapp.domain.model.customer.Customer;
import edu.uptc.swii.administratorapp.domain.model.customer.CustomerId;
import java.util.Optional;

public interface CustomerRepository {
    Customer save(Customer customer);
    Optional<Customer> findById(CustomerId customerId);
    boolean existsByDocument(String document);
}
