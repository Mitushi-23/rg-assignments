package com.springbatch.Customer_SpringBatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbatch.Customer_SpringBatch.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer>  {

}
