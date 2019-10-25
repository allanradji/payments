package com.company.payments.validator;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.company.payments.exception.ResourceException;
import com.company.payments.model.Card;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CardValidator {
	
	private final String NAME_PATTERN = "[A-Z]*";
	private final String CVV_PATTERN = "[0-9]+";
	private final int FIRST_DAY_OF_A_MONTH = 1;
	
	public void validateCreditCard(Card card) {
		validateCardIsEmpty(card);
		validateNumberCard(card);
		validateExpirationDateCard(card);
		validateCvvNumberCard(card);
		validateHolderNameCard(card);
	}

	public void validateNumberCard(Card card) {
		if(!luhnCheck(card.getNumber()))
			throw new ResourceException(HttpStatus.NOT_ACCEPTABLE, "card.number.invalid");
	}
	
	public void validateExpirationDateCard(Card card) {
		LocalDate currentMonthAndYear = LocalDate.now().withDayOfMonth(FIRST_DAY_OF_A_MONTH);
			if(card.getExpirationDate().isBefore(currentMonthAndYear))
				throw new ResourceException(HttpStatus.NOT_ACCEPTABLE, "card.date.expired");
	}
	
	public void validateCvvNumberCard(Card card) {
		if(!card.getCvv().matches(CVV_PATTERN))
			throw new ResourceException(HttpStatus.NOT_ACCEPTABLE, "card.cvv.invalid");
	}
	
	public void validateHolderNameCard(Card card) {
		if(!card.getHolderName().matches(NAME_PATTERN))
			throw new ResourceException(HttpStatus.NOT_ACCEPTABLE, "card.holder.name.invalid");
	}
	
	public void validateCardIsEmpty(Card card) {
		if(card == null)
			throw new ResourceException(HttpStatus.NOT_ACCEPTABLE, "card.empty");
	}

	private boolean luhnCheck(String cardNumber) {
		int s1 = 0, s2 = 0;
		String reverse = new StringBuffer(cardNumber).reverse().toString();
		for (int i = 0 ;i < reverse.length();i++) {
			int digit = Character.digit(reverse.charAt(i), 10);
			if(i % 2 == 0) { s1 += digit; }
			else {
				s2 += 2 * digit;
				if (digit >= 5) { s2 -= 9; }
			}
		}
		return (s1 + s2) % 10 == 0;
	}
	
}
