package edu.uptc.swii.cqrscontroller.infrastructure.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.uptc.swii.cqrscontroller.model.Login;
import edu.uptc.swii.cqrscontroller.model.Order;
import edu.uptc.swii.cqrscontroller.application.service.*;

@RestController
public class LoginController {
    
     private final LoginService loginService;


    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }


    @PostMapping("/addlogin")
    public String sendMessageOrder(@RequestBody Login login) {
        loginService.addLogin(login);
        return login.toString();
    }

}
