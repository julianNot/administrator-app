package edu.uptc.swii.cqrsquery.application.port.output.event;

public interface CustomerEventConsumer {
    public void addCustomerConsume(String message);

    public void updateCustomerConsume(String message);

    public void deleteCustomerConsume(String message);
}
