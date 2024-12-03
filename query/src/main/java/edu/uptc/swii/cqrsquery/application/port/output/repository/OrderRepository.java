package edu.uptc.swii.cqrsquery.application.port.output.repository;

public interface OrderRepository {
    public boolean updateOrderStatus(boolean status, String id);
    public void findOrderByCustomerId(String customerId);
}
