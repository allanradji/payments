package com.company.payments.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PaymentDTO implements Serializable{

	private static final long serialVersionUID = 3653918089673231275L;

	    private Long id;
	    
	    private Double amount;

	    private String type;

	    private CardDTO card;


	    private BoletoDTO boleto;
		
		private String status;
		
		
		private ClientDTO client;
		
		private BuyerDTO buyer;
	
}
