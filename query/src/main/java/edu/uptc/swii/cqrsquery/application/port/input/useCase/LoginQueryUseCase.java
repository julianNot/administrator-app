package edu.uptc.swii.cqrsquery.application.port.input.useCase;

import edu.uptc.swii.cqrsquery.domain.model.Login;

public interface LoginQueryUseCase {

    public void addLogin(Login login);
    public void getByIdLogin(Long id);

}
