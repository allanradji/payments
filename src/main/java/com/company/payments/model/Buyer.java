package com.company.payments.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

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
public class Buyer implements Serializable{

	private static final long serialVersionUID = 4983565062155744281L;

	@Id
    @EqualsAndHashCode.Include
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="buyer_id")
	private Long id;
	
	@NotNull
	private String name;
	
	private String email;
	
	@CPF
	private String cpf;
}
