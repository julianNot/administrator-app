package edu.uptc.swii.cqrsquery.adapter.input.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.uptc.swii.cqrsquery.infrastructure.adapter.input.mongo.MongoCustomerRepository;
import edu.uptc.swii.cqrsquery.infrastructure.adapter.input.mongo.MongoLoginRespository;
import edu.uptc.swii.cqrsquery.infrastructure.repository.mongoDb.CustomerMongo;
import edu.uptc.swii.cqrsquery.infrastructure.repository.mongoDb.LoginMongo;

@RestController
public class LoginQueryController {
    

    private final MongoLoginRespository loginRepository;

    public LoginQueryController(MongoLoginRespository loginRepository) {
        this.loginRepository = loginRepository;
    }


    @GetMapping("/login")
    public LoginMongo getCustomerById(@RequestParam LoginMongo login) {
        return loginRepository.findById(login.getId()).get();
    }
}
