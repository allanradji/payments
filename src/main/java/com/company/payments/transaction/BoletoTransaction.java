package com.company.payments.transaction;

import com.company.payments.model.Boleto;
import com.company.payments.model.Client;
import com.company.payments.model.Payment;
import com.company.payments.model.PaymentStatus;
import com.company.payments.util.BoletoUtil;
import com.company.payments.validator.BuyerValidator;
import com.company.payments.validator.PaymentValidator;

public class BoletoTransaction implements PaymentTransaction {

	PaymentValidator paymentValidator;
	BuyerValidator buyerValidator;
	
	public BoletoTransaction() {
		paymentValidator = new PaymentValidator();
		buyerValidator = new BuyerValidator();
	}

	@Override
	public String doTransaction(Payment payment) {
		if(payment.getClient() == null)
			payment.setClient(new Client());
			
		paymentValidator.validatePayment(payment);
		buyerValidator.validateBuyer(payment.getBuyer());
		payment.setBoleto(Boleto.builder().number(BoletoUtil.gerarCodigoDeBarras()).build());
		payment.setStatus(PaymentStatus.APPROVED);

		return payment.getBoleto().getNumber();
	}

}
