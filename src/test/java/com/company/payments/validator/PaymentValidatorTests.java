package com.company.payments.validator;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.company.payments.exception.ResourceException;
import com.company.payments.model.Card;
import com.company.payments.model.Payment;
import com.company.payments.model.PaymentType;

@RunWith(MockitoJUnitRunner.class)
public class PaymentValidatorTests {

	Card validCard;
	
	@InjectMocks
    private PaymentValidator paymentValidator;
	
	@Before
	public void setUp() {
		
		validCard = Card.builder()
				.holderName("ALLAN RADJI")
				.cvv("123")
				.number("4916220649659207")
				.expirationDate(LocalDate.now()).build();
	}
    
    @Test(expected = ResourceException.class)
    public void testPaymentWithAmountNegative() {
    	Payment negativeAmountPayment = Payment.builder()
    			.id(1L)
    			.amount(new Double(-5)).build();
    	paymentValidator.validateAmountPayment(negativeAmountPayment);
    }
    
    @Test(expected = ResourceException.class)
    public void testPaymenAmountExceedLimit() {
    	Payment paymenAmountExceedLimit = Payment.builder()
    			.id(1L)
    			.amount(new Double(Integer.MAX_VALUE)).build();
    	paymentValidator.validateAmountPayment(paymenAmountExceedLimit);
    }
    
    @Test(expected = ResourceException.class)
    public void testPaymentWithAmountZero() {
    	Payment paymentWithAmountZero = Payment.builder()
    			.id(1L)
    			.amount(new Double(0)).build();
    	paymentValidator.validateAmountPayment(paymentWithAmountZero);
    }
    
    @Test(expected = ResourceException.class)
    public void testPaymentCreditCardWithoutCard() {
    	Payment paymentWithoutCreditCard = Payment.builder()
    			.id(1L)
    			.type(PaymentType.CREDIT_CARD).build();
    	paymentValidator.validateMethodPaymentCreditCard(paymentWithoutCreditCard);
    }
    
    @Test(expected = ResourceException.class)
    public void testPaymentBoletoWithCard() {
    	
    	Payment paymentBoletoWithCard = Payment.builder()
    			.id(1L)
    			.type(PaymentType.BOLETO)
    			.card(validCard).build();
    	paymentValidator.validateMethodPaymentBoleto(paymentBoletoWithCard);
    }
    
}