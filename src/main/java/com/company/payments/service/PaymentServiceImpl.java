package com.company.payments.service;

import javax.validation.Validator;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.payments.dto.PaymentDTO;
import com.company.payments.exception.PaymentNotFoundException;
import com.company.payments.model.Client;
import com.company.payments.model.Payment;
import com.company.payments.model.PaymentType;
import com.company.payments.repository.PaymentRepository;
import com.company.payments.validator.BuyerValidator;
import com.company.payments.validator.CardValidator;
import com.company.payments.validator.PaymentValidator;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService{

    private final PaymentRepository paymentRepository;

    @Override
    public PaymentDTO create(PaymentDTO paymentDTO) {
    	Payment payment = new ModelMapper().map(paymentDTO, Payment.class);
    	
    	if(payment.getClient() == null)
    		payment.setClient(new Client());
    	
    	PaymentValidator paymentValidator = new PaymentValidator();
    	CardValidator cardValidator = new CardValidator();
    	BuyerValidator buyerValidator = new BuyerValidator();
    	
    	if(payment.getType().equals(PaymentType.CREDIT_CARD))
    		
    		paymentValidator.validatePayment(payment);
    		cardValidator.validateCreditCard(payment.getCard());
    		buyerValidator.validateBuyer(payment.getBuyer());
    		
    	payment = paymentRepository.save(payment);	
    	return new ModelMapper().map(payment, PaymentDTO.class);
    }
    
	@Override
	public PaymentDTO findById(long id) {
       Payment payment = paymentRepository.findById(id)
                                .orElseThrow(() -> new PaymentNotFoundException(id));

       return new ModelMapper().map(payment,PaymentDTO.class);
    }

}