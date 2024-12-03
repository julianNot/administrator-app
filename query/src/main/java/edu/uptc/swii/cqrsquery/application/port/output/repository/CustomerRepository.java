package edu.uptc.swii.cqrsquery.application.port.output.repository;

import edu.uptc.swii.cqrsquery.infrastructure.repository.mongoDb.CustomerMongo;

public interface CustomerRepository {
    
    public void createCustomer(CustomerMongo customer);
    public CustomerMongo findCustomerById(String customerId);


}
