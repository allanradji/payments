package com.company.payments.validator;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.company.payments.exception.ResourceException;
import com.company.payments.message.SourceMessage;
import com.company.payments.model.Card;

@RunWith(MockitoJUnitRunner.class)
public class CardValidatorTests {

    private static final int LIMIT_OF_DAYS_FOR_A_MONTH = 31;

	@InjectMocks
    private CardValidator cardValidator;

    @Mock
    private SourceMessage messageSource;
    
    @Test(expected = ResourceException.class)
    public void testCardWithExpirationDateInvalid() {
    	Card expiredCard = Card.builder()
    			.id(1L)
    			.expirationDate(LocalDate.now().minusDays(LIMIT_OF_DAYS_FOR_A_MONTH)).build();
    	cardValidator.validateExpirationDateCard(expiredCard);
    }
    
    @Test(expected = ResourceException.class)
    public void testCardWithNumberInvalid() {
    	Card cardWithNumberInvalid = Card.builder()
    			.id(1L)
    			.number("4916220649659206").build();
    	cardValidator.validateNumberCard(cardWithNumberInvalid);
    }
    
    @Test(expected = ResourceException.class)
    public void testCardWithHolderNameInvalid() {
    	Card cardWithHolderNameInvalid = Card.builder()
    			.id(1L)
    			.holderName(" Allan R'adji - . ").build();
    	cardValidator.validateHolderNameCard(cardWithHolderNameInvalid);
    }
    
    @Test(expected = ResourceException.class)
    public void testCardWithCVVInvalid() {
    	Card CardWithCVVInvalid = Card.builder()
    			.id(1L)
    			.cvv("1a2").build();
    	cardValidator.validateCvvNumberCard(CardWithCVVInvalid);
    }
    
}
