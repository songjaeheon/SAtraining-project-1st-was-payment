package com.footballmania.waspayment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.footballmania.waspayment.dto.PaymentRequestDto;
import com.footballmania.waspayment.service.PaymentService;

@RestController
@RequestMapping("/payment")
@CrossOrigin(origins = {"http://footballmania.com", "https://footballmania.com"})
public class PaymentController {
    
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/process")
    public ResponseEntity<?> processPayment(@RequestBody PaymentRequestDto paymentRequestDto) {
        //  payment processing logic
        try {
            System.out.println(" amount: " + paymentRequestDto.getAmount());
            paymentService.processPayment(paymentRequestDto.getAmount());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Payment failed");
        }
        return ResponseEntity.ok("Payment successful");
    }

}
