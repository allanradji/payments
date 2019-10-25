package com.company.payments.service;

import com.company.payments.dto.PaymentDTO;

public interface PaymentService {

    public String create(PaymentDTO paymentDTO);
    public PaymentDTO findById(long id);
}
