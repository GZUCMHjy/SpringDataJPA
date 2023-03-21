package com.example.jpa_demo.Repository;

import com.example.jpa_demo.Pojo.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer>,QuerydslPredicateExecutor<Customer> {

}
