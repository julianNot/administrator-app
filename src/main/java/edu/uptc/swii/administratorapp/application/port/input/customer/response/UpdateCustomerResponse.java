package edu.uptc.swii.administratorapp.application.port.input.customer.response;

public record UpdateCustomerResponse(
    String customerId,
    UpdateStatus status,
    String message
) {
    public enum UpdateStatus {
        SUCCESS,
        CUSTOMER_NOT_FOUND,
        VALIDATION_ERROR,
        ERROR
    }

    // Constructor de conveniencia para respuestas exitosas
    public static UpdateCustomerResponse success(String customerId) {
        return new UpdateCustomerResponse(customerId, UpdateStatus.SUCCESS, "Customer updated successfully");
    }

    // Constructor de conveniencia para cliente no encontrado
    public static UpdateCustomerResponse notFound(String customerId) {
        return new UpdateCustomerResponse(customerId, UpdateStatus.CUSTOMER_NOT_FOUND, "Customer not found");
    }

    // Constructor de conveniencia para errores de validación
    public static UpdateCustomerResponse validationError(String customerId, String error) {
        return new UpdateCustomerResponse(customerId, UpdateStatus.VALIDATION_ERROR, error);
    }

    // Constructor de conveniencia para errores generales
    public static UpdateCustomerResponse error(String customerId, String error) {
        return new UpdateCustomerResponse(customerId, UpdateStatus.ERROR, error);
    }

    // Métodos de utilidad para verificar el estado
    public boolean isSuccess() {
        return status == UpdateStatus.SUCCESS;
    }

    public boolean isError() {
        return status != UpdateStatus.SUCCESS;
    }
}
