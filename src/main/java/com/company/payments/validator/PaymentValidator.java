package com.company.payments.validator;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.company.payments.exception.ResourceException;
import com.company.payments.model.Payment;
import com.company.payments.model.PaymentType;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PaymentValidator {
	
	private static final int MIN_LIMIT_TO_PAYMENT = 0;
	private static final int MAX_LIMIT_TO_PAYMENT = 999999999;
	
	BuyerValidator buyerValidator;
	
	public void validateCreditPayment(Payment payment) {
		validateAmountPayment(payment);
		validateMethodPaymentCreditCard(payment);
		validateMethodPaymentBoleto(payment);
	}
	
	public void validateMethodPaymentCreditCard(Payment payment) {
		if(payment.getType().equals(PaymentType.CREDIT_CARD)
				&& payment.getCard() == null)
			throw new ResourceException(HttpStatus.NOT_ACCEPTABLE, "payment.card.empty");
	}
	
	public void validateMethodPaymentBoleto(Payment payment) {
	if(payment.getType().equals(PaymentType.BOLETO) 
			&& (payment.getCard() != null))
		throw new ResourceException(HttpStatus.NOT_ACCEPTABLE, "payment.type.incompatible");
	}
	
	public void validateAmountPayment(Payment payment) {
		if(payment.getAmount() <= MIN_LIMIT_TO_PAYMENT
				|| payment.getAmount() > MAX_LIMIT_TO_PAYMENT)
			throw new ResourceException(HttpStatus.NOT_ACCEPTABLE, "payment.amount.invalid");
	}
	
}