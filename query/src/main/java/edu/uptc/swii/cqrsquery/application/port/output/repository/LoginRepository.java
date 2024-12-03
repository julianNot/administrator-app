package edu.uptc.swii.cqrsquery.application.port.output.repository;

public interface LoginRepository {
    public void createUser(String customerId);
    public boolean authUser(String customerId, String password);

}
