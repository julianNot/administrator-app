package edu.uptc.swii.cqrscontroller.infrastructure.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import edu.uptc.swii.cqrscontroller.model.Customer;


public interface CustomerRepository extends JpaRepository<Customer, String> {


}

