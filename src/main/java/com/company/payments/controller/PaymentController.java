package com.company.payments.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.payments.dto.PaymentDTO;
import com.company.payments.model.Payment;
import com.company.payments.service.PaymentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/payments")
@AllArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping("/{id}")
    public PaymentDTO findById(@PathVariable(name = "id", required = true) Long id) {
        return convertToDTO(paymentService.findById(id));
    }
    
    @PostMapping
    public PaymentDTO create(@RequestBody(required = true) PaymentDTO paymentDTO) {
        return convertToDTO(paymentService.create(convertToPayment(paymentDTO)));
    }
    
    public PaymentDTO convertToDTO(Payment payment) {
    	return PaymentDTO.builder().id(payment.getId()).build();
    }
    
    public Payment convertToPayment(PaymentDTO paymentDTO) {
    	return Payment.builder().id(paymentDTO.getId()).build();
    }
}
