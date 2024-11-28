package edu.uptc.swii.administratorapp.domain.model.customer;

public record CustomerName(String firstName, String lastName) {
    public CustomerName {
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("First name cannot be empty");
        }
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be empty");
        }
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
