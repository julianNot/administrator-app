package edu.uptc.swii.cqrsquery.adapter.input.rest;

import org.springframework.web.bind.annotation.RestController;

import edu.uptc.swii.cqrsquery.infrastructure.adapter.input.mongo.MongoCustomerRepository;
import edu.uptc.swii.cqrsquery.infrastructure.repository.mongoDb.CustomerMongo;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class CustomerQueryController {
    private final MongoCustomerRepository customerRepository;

    public CustomerQueryController(MongoCustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/allcustomers")
    public List<CustomerMongo> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/findcustomerbyid")
    public CustomerMongo getCustomerById(@RequestParam String id) {
        return customerRepository.findById(id).get();
    }
    
    
}
