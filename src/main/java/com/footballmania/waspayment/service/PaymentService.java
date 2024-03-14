package com.footballmania.waspayment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.footballmania.waspayment.config.CustomUserDetails;
import com.footballmania.waspayment.entity.Payment;
import com.footballmania.waspayment.repository.PaymentRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Transactional
    public void processPayment(int amount) {
        String name = ((CustomUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getEmail();
        paymentRepository.save(new Payment(amount, name));
    }
}
