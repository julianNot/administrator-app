package edu.uptc.swii.cqrsquery.infrastructure.adapter.input.mongo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.uptc.swii.cqrsquery.infrastructure.repository.mongoDb.OrderMongo;

public interface MongoOrderRepository extends MongoRepository<OrderMongo, String> {
    Optional<OrderMongo> findByCustomerId(String customerId);
}
