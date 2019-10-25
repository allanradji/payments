package com.company.payments.transaction;

import com.company.payments.model.PaymentType;

public class PaymentTransactionFactory {
	
	public static PaymentTransaction getTransaction(PaymentType paymentType) {
		PaymentTransaction paymentTransaction = null;
		
		switch (paymentType) {
			case CREDIT_CARD: paymentTransaction = new CreditCardTransaction();
			case BOLETO: paymentTransaction = new BoletoTransaction();
		}
		
		return paymentTransaction;
	}
}
