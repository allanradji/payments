package com.company.payments.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.payments.exception.PaymentNotFoundException;
import com.company.payments.model.Payment;
import com.company.payments.repository.PaymentRepository;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService{

    private final PaymentRepository paymentRepository;
    
    @Override
    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment create(Payment payment) {
        return paymentRepository.save(payment);
    }
    
	@Override
	public Payment findById(long id) {
        return paymentRepository.findById(id)
                                .orElseThrow(() -> new PaymentNotFoundException(id));
    }

}