package com.company.payments.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.payments.dto.PaymentDTO;
import com.company.payments.service.PaymentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/payments")
@AllArgsConstructor
public class PaymentController {

	@Autowired
    private final PaymentService paymentService;

//    @GetMapping("/{id}")
//    public PaymentDTO findById(@PathVariable(name = "id", required = true) Long id) {
//        return convertToDTO(paymentService.findById(id));
//    }
    
    @PostMapping
    public ResponseEntity<PaymentDTO> create(@Valid @RequestBody PaymentDTO paymentDTO) {
    	PaymentDTO paymentResponse = paymentService.create(paymentDTO);
    	return ResponseEntity.status(HttpStatus.CREATED).body(paymentResponse);
    }
    
}
