package edu.uptc.swii.cqrsquery.infrastructure.repository.mongoDb;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection="order")
public class OrderMongo {
     @Id
    @JsonProperty("orderId")
    private String orderId;
    @JsonProperty("customerId")
    private String customerId;
    @JsonProperty("status")
    private String status;
    
    public OrderMongo() {
    }

    public OrderMongo(String orderId, String customerId, String status) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.status = status;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Customer [orderId=" + orderId + ", customerId=" + customerId + ", status=" + status + "]";
    }
}
