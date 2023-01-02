package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.CustomerDB;

public interface CustomerRepository extends JpaRepository<CustomerDB, Long> {

}
