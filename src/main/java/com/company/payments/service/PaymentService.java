package com.company.payments.service;

import java.util.List;
import java.util.Optional;

import com.company.payments.model.Payment;

public interface PaymentService {

    public List<Payment> findAll();
    public Payment create(Payment Payment);
    public Payment findById(long id);
}
