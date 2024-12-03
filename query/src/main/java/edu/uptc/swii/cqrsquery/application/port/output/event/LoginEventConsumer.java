package edu.uptc.swii.cqrsquery.application.port.output.event;

public interface LoginEventConsumer {
    
    public void addLoginConsume(String message);
}
