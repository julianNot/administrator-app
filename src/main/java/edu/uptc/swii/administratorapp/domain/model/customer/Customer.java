package edu.uptc.swii.administratorapp.domain.model.customer; 

import edu.uptc.swii.administratorapp.domain.model.common.Email;
import edu.uptc.swii.administratorapp.domain.model.common.Phone;
import edu.uptc.swii.administratorapp.domain.exception.CustomerValidationException;


public class Customer {
    private final CustomerId id;
    private final CustomerDocument document;
    private final CustomerName name;
    private final CustomerAddress address;
    private final Phone phone;
    private final Email email;

    private Customer(Builder builder) {
        this.id = builder.id;
        this.document = builder.document;
        this.name = builder.name;
        this.address = builder.address;
        this.phone = builder.phone;
        this.email = builder.email;
        validate();
    }

    private void validate() {
        if (id == null) throw new CustomerValidationException("Customer ID is required");
        if (document == null) throw new CustomerValidationException("Document is required");
        if (name == null) throw new CustomerValidationException("Name is required");
        if (address == null) throw new CustomerValidationException("Address is required");
        if (phone == null) throw new CustomerValidationException("Phone is required");
        if (email == null) throw new CustomerValidationException("Email is required");
    }

    public static Builder builder() {
        return new Builder();
    }

    // Getters
    public CustomerId getId() { return id; }
    public CustomerDocument getDocument() { return document; }
    public CustomerName getName() { return name; }
    public CustomerAddress getAddress() { return address; }
    public Phone getPhone() { return phone; }
    public Email getEmail() { return email; }

    public static class Builder {
        private CustomerId id;
        private CustomerDocument document;
        private CustomerName name;
        private CustomerAddress address;
        private Phone phone;
        private Email email;

        public Builder id(String id) {
            this.id = new CustomerId(id);
            return this;
        }

        public Builder document(String document) {
            this.document = new CustomerDocument(document);
            return this;
        }

        public Builder name(String firstName, String lastName) {
            this.name = new CustomerName(firstName, lastName);
            return this;
        }

        public Builder address(String street, String city, String country) {
            this.address = new CustomerAddress(street, city, country);
            return this;
        }

        public Builder phone(String phone) {
            this.phone = new Phone(phone);
            return this;
        }

        public Builder email(String email) {
            this.email = new Email(email);
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
}
