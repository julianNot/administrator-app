package edu.uptc.swii.cqrsquery.application.port.output.event;


public interface OrderEventConsumer {
    
    public void addOrderConsume(String message);

    public void updateOrderConsume(String message);

}
