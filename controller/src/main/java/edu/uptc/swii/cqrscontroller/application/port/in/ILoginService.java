package edu.uptc.swii.cqrscontroller.application.port.in;

import edu.uptc.swii.cqrscontroller.model.Login;

public interface ILoginService {
 
    public Login addLogin(Login login);
}
