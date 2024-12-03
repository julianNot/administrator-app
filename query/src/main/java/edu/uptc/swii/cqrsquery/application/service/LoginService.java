package edu.uptc.swii.cqrsquery.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uptc.swii.cqrsquery.infrastructure.adapter.input.mongo.MongoLoginRespository;
import edu.uptc.swii.cqrsquery.infrastructure.repository.mongoDb.LoginMongo;

@Service
public class LoginService {
    
      @Autowired
    private final MongoLoginRespository loginRepository;


    public LoginService(MongoLoginRespository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public void addLogin(LoginMongo login){
        loginRepository.insert(login);        
    }

    public void getByIdLogin(Long id){
        loginRepository.findById(id);
    }

}
