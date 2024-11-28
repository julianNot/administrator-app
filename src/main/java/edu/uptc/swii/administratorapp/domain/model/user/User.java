package edu.uptc.swii.administratorapp.domain.model.user;

import edu.uptc.swii.administratorapp.domain.model.customer.CustomerId;
import edu.uptc.swii.administratorapp.domain.exception.UserValidationException;

public class User {
    private final UserId id;
    private final CustomerId customerId;
    private Password password;

    private User(Builder builder) {
        this.id = builder.id;
        this.customerId = builder.customerId;
        this.password = builder.password;
        validate();
    }

    private void validate() {
        if (id == null) throw new UserValidationException("User ID is required");
        if (customerId == null) throw new UserValidationException("Customer ID is required");
        if (password == null) throw new UserValidationException("Password is required");
    }

    public void updatePassword(Password newPassword) {
        if (newPassword == null) {
            throw new UserValidationException("New password cannot be null");
        }
        this.password = newPassword;
    }

    public static Builder builder() {
        return new Builder();
    }

    // Getters
    public UserId getId() { return id; }
    public CustomerId getCustomerId() { return customerId; }
    public Password getPassword() { return password; }

    public static class Builder {
        private UserId id;
        private CustomerId customerId;
        private Password password;

        public Builder id(String id) {
            this.id = new UserId(id);
            return this;
        }

        public Builder customerId(String customerId) {
            this.customerId = new CustomerId(customerId);
            return this;
        }

        public Builder password(String password) {
            this.password = new Password(password);
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}