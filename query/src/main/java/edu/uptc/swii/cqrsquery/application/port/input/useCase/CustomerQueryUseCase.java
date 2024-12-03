package edu.uptc.swii.cqrsquery.application.port.input.useCase;

import java.util.List;

import edu.uptc.swii.cqrsquery.domain.model.Customer;

public interface CustomerQueryUseCase {
    
    public void addCustomer(Customer customer);

    public void updateCustomer(Customer customer);

    public void deleteCustomer(Customer customer);

    public List<Customer> getAllCustomers();

    public Customer getCustomerById(String id);
}
