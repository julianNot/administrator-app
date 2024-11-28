package edu.uptc.swii.administratorapp.domain.model.customer;

public record CustomerAddress(String street, String city, String country) {
    public CustomerAddress {
        if (street == null || street.trim().isEmpty()) {
            throw new IllegalArgumentException("Street cannot be empty");
        }
        if (city == null || city.trim().isEmpty()) {
            throw new IllegalArgumentException("City cannot be empty");
        }
        if (country == null || country.trim().isEmpty()) {
            throw new IllegalArgumentException("Country cannot be empty");
        }
    }

    public String getFullAddress() {
        return String.format("%s, %s, %s", street, city, country);
    }
}
