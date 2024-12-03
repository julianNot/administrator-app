package edu.uptc.swii.cqrsquery.infrastructure.adapter.output.kafka2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import edu.uptc.swii.cqrsquery.application.port.output.event.CustomerEventConsumer;
import edu.uptc.swii.cqrsquery.application.service.CustomerService;
import edu.uptc.swii.cqrsquery.infrastructure.repository.mongoDb.CustomerMongo;
import edu.uptc.swii.cqrsquery.infrastructure.utils.JsonUtils;

@Service
public class KafkaCustomerEventConsumer implements CustomerEventConsumer{
    @Autowired
    private CustomerService customerService;

    @KafkaListener(topics = "add-customer-topic", groupId = "customer-group")
    public void addCustomerConsume(String message) {
        message=message.replace("\\","");
        message=message.substring(1, message.length()-1);
        System.out.println("Add Customer - Received Message: " + message);
        JsonUtils jsonUtils = new JsonUtils();
        CustomerMongo savedCustomer = jsonUtils.fromJson(message, CustomerMongo.class);
        customerService.addCustomer(savedCustomer);

    }

    @KafkaListener(topics = "update-customer-topic", groupId = "customer-group")
    public void updateCustomerConsume(String message) {
        System.out.println("Update Customer - Received Message: " + message);
        message=message.replace("\\","");
        message=message.substring(1, message.length()-1);
        JsonUtils jsonUtils = new JsonUtils();
        CustomerMongo savedCustomer = jsonUtils.fromJson(message, CustomerMongo.class);
        customerService.updateCustomer(savedCustomer);
    }

    @KafkaListener(topics = "delete-customer-topic", groupId = "customer-group")
    public void deleteCustomerConsume(String message) {
        System.out.println("Delete Customer - Received Message: " + message);
        message=message.replace("\\","");
        message=message.substring(1, message.length()-1);
        JsonUtils jsonUtils = new JsonUtils();
        CustomerMongo savedCustomer = jsonUtils.fromJson(message, CustomerMongo.class);
        customerService.deleteCustomer(savedCustomer);
    }
}
