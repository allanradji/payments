package com.company.payments.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Data;

@Data
public class CardResponse implements Serializable {

	private static final long serialVersionUID = -3804161057459018506L;
	
	private Long id;

	private String holderName;
	
	private String number;
	
	private LocalDate expirationDate;
	
	private String cvv;

}
