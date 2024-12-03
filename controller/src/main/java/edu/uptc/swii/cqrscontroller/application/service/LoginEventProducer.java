package edu.uptc.swii.cqrscontroller.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import edu.uptc.swii.cqrscontroller.model.Login;
import edu.uptc.swii.cqrscontroller.application.utils.*;;

@Service
public class LoginEventProducer {
    
     @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    private String type;
    private Login login;
    
    public String getType() {
        return type;
    }


    public Login getLogin() {
        return login;
    }

    public void sendMessage(String topic, Login login) {
        String message = new String();
        JsonUtils jsonUtils = new JsonUtils();
        message = jsonUtils.toJson(login);
        System.out.println("loginEventProducer sendMessage: "+message);
        kafkaTemplate.send(topic, message);
    }

}
