package com.company.payments.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PaymentRequest implements Serializable{

	private static final long serialVersionUID = -3358175582569900877L;
	
	@NotNull(message = "Amount cannot be null.")
    private Double amount;
	
	@NotEmpty(message = "type cannot be empty.")
	private String type;
	
	@NotNull(message = "Card id cannot be null.")
	private Long idCard;
	
	@NotNull(message = "Boleto id cannot be null.")
	private Long idBoleto;
	
	@NotEmpty(message = "Status cannot be empty.")
	private String status;
	
	@NotNull(message = "Client id cannot be null.")
	private Long idClient;
	
	@NotNull(message = "Client id cannot be null.")
	private Long idBuyer;
	
}
