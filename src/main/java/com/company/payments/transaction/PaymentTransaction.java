package com.company.payments.transaction;

import com.company.payments.model.Payment;

public interface PaymentTransaction {

	public String doTransaction(Payment payment);
}
