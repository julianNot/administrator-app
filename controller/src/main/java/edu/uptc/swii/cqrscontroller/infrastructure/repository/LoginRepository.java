package edu.uptc.swii.cqrscontroller.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uptc.swii.cqrscontroller.model.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {

    
} 