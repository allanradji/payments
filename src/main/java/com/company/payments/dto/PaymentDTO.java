package com.company.payments.dto;

import java.io.Serializable;

import com.company.payments.model.Buyer;
import com.fasterxml.jackson.annotation.JsonProperty;

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

		@JsonProperty("payment_id")
	    private Long id;
	    
	    private Double amount;

	    private String type;

	    private Double balance;

	    @JsonProperty("card_id")
	    private Long cardId;

	    @JsonProperty("boleto_id")
	    private Long boletoId;
		
		private String status;
		
		@JsonProperty("client_id")
		private Long clientId;
		
		@JsonProperty("buyer_id")
		private Buyer buyerId;
	
}
