package com.company.payments.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Card implements Serializable{

	private static final long serialVersionUID = -553843829368894766L;
	
	@Id
    @EqualsAndHashCode.Include
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="card_id")
	private Long id;

	@NotNull
	@Column(name = "holder_name")
	private String holderName;
	
	@NotNull
	@Size(min = 16, max = 16, message = "number should have 16 digits")
	private String number;
	
	@NotNull
	@Column(name = "expiration_date")
	private LocalDate expirationDate;
	
	@NotNull
	@Size(min = 3, max = 3, message = "CVV should have 3 digits")
	private String cvv;
}
