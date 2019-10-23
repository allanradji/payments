package com.company.payments.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

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
public class Payment implements Serializable{

	private static final long serialVersionUID = 6220723792379765510L;
	
	@Id
    @EqualsAndHashCode.Include
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="payment_id")
	private Long id;
	
	@NotNull
	private Double amount;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private PaymentType type;
	
	@ManyToOne
	@JoinColumn(name = "card_id", nullable = true)
	private Card card;
}
