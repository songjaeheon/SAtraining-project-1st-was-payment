package com.footballmania.waspayment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.footballmania.waspayment.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>{

    
}
