package com.bootcamp.Payment.repo;

import com.bootcamp.Payment.entities.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment,Integer> {
}
