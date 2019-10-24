package com.company.payments.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class PaymentResponse implements Serializable {

	private static final long serialVersionUID = -7802142192391869705L;

	private Double amount;
	
	private String type;
	
	private CardResponse card;
	
	//private BoletoResponse boleto;
	
	private String status;
	
	//private ClientResponse client;

	//private BuyerResponse buyer;

}
