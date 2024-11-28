package edu.uptc.swii.administratorapp.application.port.input.order.response;

import java.util.List;

public record FindOrdersResponse(
    List<OrderResponse> orders
) {
    public record OrderResponse(
        String orderId,
        String customerId,
        String status
    ) {}
}
