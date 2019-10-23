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
public class BoletoDTO implements Serializable{

	private static final long serialVersionUID = 7115579220659961424L;
	
	@JsonProperty("boleto_id")
    private Long id;
    
	private String number;

}
