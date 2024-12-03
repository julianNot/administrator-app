package edu.uptc.swii.cqrsquery.infrastructure.adapter.output.kafka2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import edu.uptc.swii.cqrsquery.application.port.output.event.LoginEventConsumer;
import edu.uptc.swii.cqrsquery.application.service.LoginService;
import edu.uptc.swii.cqrsquery.infrastructure.repository.mongoDb.CustomerMongo;
import edu.uptc.swii.cqrsquery.infrastructure.repository.mongoDb.LoginMongo;
import edu.uptc.swii.cqrsquery.infrastructure.utils.JsonUtils;

@Service
public class KafkaLoginEventConsumer implements LoginEventConsumer{
    
    @Autowired
    private LoginService loginService;

    @KafkaListener(topics = "add-login-topic", groupId = "customer-group")
    public void addLoginConsume(String message) {
        message=message.replace("\\","");
        message=message.substring(1, message.length()-1);
        System.out.println("Add Login - Received Message: " + message);
        JsonUtils jsonUtils = new JsonUtils();
        LoginMongo savedLogin = jsonUtils.fromJson(message, LoginMongo.class);
        loginService.addLogin(savedLogin);

    }

}
