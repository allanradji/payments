package com.company.payments.transaction;

import com.company.payments.model.Client;
import com.company.payments.model.Payment;
import com.company.payments.model.PaymentStatus;
import com.company.payments.validator.BuyerValidator;
import com.company.payments.validator.CardValidator;
import com.company.payments.validator.PaymentValidator;


public class CreditCardTransaction implements PaymentTransaction {
	
	CardValidator cardValidator;
	PaymentValidator paymentValidator;
	BuyerValidator buyerValidator;
	
	public CreditCardTransaction() {
		cardValidator = new CardValidator();
		paymentValidator = new PaymentValidator();
		buyerValidator = new BuyerValidator();
	}

	@Override
	public String doTransaction(Payment payment) {
		if(payment.getClient() == null)
			payment.setClient(new Client());
		
		paymentValidator.validatePayment(payment);
		cardValidator.validateCreditCard(payment.getCard());
		buyerValidator.validateBuyer(payment.getBuyer());
		payment.setStatus(PaymentStatus.APPROVED);

		return payment.getStatus().name();
	}

}
