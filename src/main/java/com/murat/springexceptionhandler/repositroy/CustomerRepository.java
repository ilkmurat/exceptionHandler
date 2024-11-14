package com.murat.springexceptionhandler.repositroy;


import com.murat.springexceptionhandler.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
