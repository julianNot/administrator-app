package edu.uptc.swii.cqrscontroller.application.service;

import org.springframework.stereotype.Service;

import edu.uptc.swii.cqrscontroller.model.Login;
import edu.uptc.swii.cqrscontroller.application.port.in.ILoginService;
import edu.uptc.swii.cqrscontroller.infrastructure.repository.*;;

@Service
public class LoginService implements ILoginService{

     private final LoginRepository loginRepository;
    private final LoginEventProducer loginEventProducer;
    private final String ADD_LOGIN_TOPIC = "add-login-topic";
    

     public LoginService(edu.uptc.swii.cqrscontroller.infrastructure.repository.LoginRepository loginRepository,
            LoginEventProducer loginEventProducer) {
        this.loginRepository = loginRepository;
        this.loginEventProducer = loginEventProducer;
    }


    public Login addLogin(Login login){
        Login savedLogin = loginRepository.save(login);
        loginEventProducer.sendMessage(ADD_LOGIN_TOPIC,login);
        return savedLogin;
    }
}
