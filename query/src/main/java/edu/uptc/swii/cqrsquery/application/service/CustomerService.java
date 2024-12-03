package edu.uptc.swii.cqrsquery.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uptc.swii.cqrsquery.infrastructure.adapter.input.mongo.MongoCustomerRepository;
import edu.uptc.swii.cqrsquery.infrastructure.repository.mongoDb.CustomerMongo;

@Service
public class CustomerService {
    @Autowired
    private final MongoCustomerRepository customerRepository;
    
    public CustomerService(MongoCustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void addCustomer(CustomerMongo customer){
        customerRepository.insert(customer);        
    }

    public void updateCustomer(CustomerMongo customer){
        customerRepository.save(customer);
    }

    public void deleteCustomer(CustomerMongo customer){
        customerRepository.delete(customer);
    }

    public List<CustomerMongo> getAllCustomers(){
        return customerRepository.findAll();
    }

    public CustomerMongo getCustomerById(String id){
        Optional<CustomerMongo> optCustomer = customerRepository.findById(id);
        return optCustomer.get();
    }
    
}
