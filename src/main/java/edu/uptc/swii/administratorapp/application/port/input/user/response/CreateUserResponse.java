package edu.uptc.swii.administratorapp.application.port.input.user.response;


public record CreateUserResponse(
    String userId,
    String customerId,
    CreateUserStatus status,
    String message
) {
    public enum CreateUserStatus {
        SUCCESS,
        CUSTOMER_NOT_FOUND,
        USER_ALREADY_EXISTS,
        VALIDATION_ERROR,
        ERROR
    }

    // Constructores estáticos para diferentes escenarios
    public static CreateUserResponse success(String userId, String customerId) {
        return new CreateUserResponse(
            userId,
            customerId,
            CreateUserStatus.SUCCESS,
            "User created successfully"
        );
    }

    public static CreateUserResponse customerNotFound(String customerId) {
        return new CreateUserResponse(
            null,
            customerId,
            CreateUserStatus.CUSTOMER_NOT_FOUND,
            "Customer not found"
        );
    }

    public static CreateUserResponse userAlreadyExists(String customerId) {
        return new CreateUserResponse(
            null,
            customerId,
            CreateUserStatus.USER_ALREADY_EXISTS,
            "User already exists for this customer"
        );
    }

    public static CreateUserResponse validationError(String customerId, String errorDetail) {
        return new CreateUserResponse(
            null,
            customerId,
            CreateUserStatus.VALIDATION_ERROR,
            "Validation error: " + errorDetail
        );
    }

    public static CreateUserResponse error(String customerId, String errorDetail) {
        return new CreateUserResponse(
            null,
            customerId,
            CreateUserStatus.ERROR,
            "Error creating user: " + errorDetail
        );
    }

    // Métodos de utilidad
    public boolean isSuccess() {
        return status == CreateUserStatus.SUCCESS;
    }

    public boolean isError() {
        return status != CreateUserStatus.SUCCESS;
    }
}
