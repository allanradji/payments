package com.company.payments.validator;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.company.payments.exception.ResourceException;
import com.company.payments.model.Buyer;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BuyerValidator {
	
	private final String EMAIL_PATTERN = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
	private final String NAME_PATTERN = "[A-Z]+([ '-][a-zA-Z]+)*";

	public void validateBuyer(Buyer buyer) {
		validateNameBuyer(buyer);
		validateEmailBuyer(buyer);
	}

	public void validateEmailBuyer(Buyer buyer) {
		if(!buyer.getEmail().toUpperCase().matches(EMAIL_PATTERN))
			throw new ResourceException(HttpStatus.NOT_ACCEPTABLE, "buyer.email.invalid");
	}

	public void validateNameBuyer(Buyer buyer) {
		if(!buyer.getName().toUpperCase().matches(NAME_PATTERN))
			throw new ResourceException(HttpStatus.NOT_ACCEPTABLE, "buyer.name.invalid");
	}

}
