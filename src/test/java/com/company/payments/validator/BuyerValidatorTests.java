package com.company.payments.validator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.company.payments.exception.ResourceException;
import com.company.payments.model.Buyer;

@RunWith(MockitoJUnitRunner.class)

public class BuyerValidatorTests {

	@InjectMocks
    private BuyerValidator buyerValidator;
    
    @Test(expected = ResourceException.class)
    public void testBuyerWithNameInvalid() {
    	Buyer buyerWithInvalidName = Buyer.builder()
    			.id(1L)
    			.name("Al 9 das '").build();
    	buyerValidator.validateNameBuyer(buyerWithInvalidName);
    }
    
    @Test(expected = ResourceException.class)
    public void testBuyerWithEmailInvalid() {
    	Buyer buyerWithInvalidEmail = Buyer.builder()
    			.id(1L)
    			.email("allan@radji").build();
    	buyerValidator.validateEmailBuyer(buyerWithInvalidEmail);
    }
    
}