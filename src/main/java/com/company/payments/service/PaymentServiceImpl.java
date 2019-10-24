package com.company.payments.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.payments.dto.PaymentDTO;
import com.company.payments.exception.PaymentNotFoundException;
import com.company.payments.model.Client;
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
    public PaymentDTO create(PaymentDTO paymentDTO) {
		
    	Payment payment = new ModelMapper().map(paymentDTO, Payment.class);
    	
    	if(payment.getClient() == null)
    		payment.setClient(new Client());
    		
    	payment = paymentRepository.save(payment);
    	
    	return new ModelMapper().map(payment, PaymentDTO.class);
    }
    
	@Override
	public Payment findById(long id) {
        return paymentRepository.findById(id)
                                .orElseThrow(() -> new PaymentNotFoundException(id));
    }

}