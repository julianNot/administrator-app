package edu.uptc.swii.cqrscontroller.application.port.in;

import edu.uptc.swii.cqrscontroller.model.Customer;

public interface ICustomerService {
    public Customer addCustomer(Customer customer);

    public Customer updateCustomer(Customer customer);


    public String deleteCustomer(Customer customer);
}
