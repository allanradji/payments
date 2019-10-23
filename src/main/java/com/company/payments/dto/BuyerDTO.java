package com.company.payments.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BuyerDTO implements Serializable {

	private static final long serialVersionUID = -4894197054897249477L;
	
	@JsonProperty("buyer_id")
    private Long id;
	
	private String name;
	
	private String email;
	
	private String cpf;

}