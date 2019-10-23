package com.company.payments.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CardDTO implements Serializable{

	private static final long serialVersionUID = 7974199126392662963L;

	@Column(name="card_id")
	private Long id;

	@Column(name="holder_name")
	private String holderName;
	
	private String number;
	
	@Column(name="expiration_date")
	private LocalDate expirationDate;
	
	private String cvv;
}
