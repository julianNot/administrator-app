package edu.uptc.swii.cqrsquery.infrastructure.adapter.output.mongo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import edu.uptc.swii.cqrsquery.application.port.output.repository.CustomerRepository;
import edu.uptc.swii.cqrsquery.domain.model.Customer;
import edu.uptc.swii.cqrsquery.infrastructure.adapter.input.mongo.MongoCustomerRepository;
import edu.uptc.swii.cqrsquery.infrastructure.repository.mongoDb.CustomerMongo;

public class MongoCustomerRepositoryAdapter implements CustomerRepository {

    @Autowired
    private final MongoCustomerRepository customerRepository;

    MongoCustomerRepositoryAdapter( MongoCustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    public void createCustomer(CustomerMongo customer) {
        customerRepository.insert(customer);    
    }

    @Override
    public CustomerMongo findCustomerById(String customerId) {
        Optional<CustomerMongo> optCustomer = customerRepository.findById(customerId);
        return optCustomer.get();
    }
    
}
