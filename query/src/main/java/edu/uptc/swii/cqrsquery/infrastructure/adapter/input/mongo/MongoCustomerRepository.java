package edu.uptc.swii.cqrsquery.infrastructure.adapter.input.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.uptc.swii.cqrsquery.infrastructure.repository.mongoDb.CustomerMongo;

public interface MongoCustomerRepository extends MongoRepository<CustomerMongo, String> {
    
}
