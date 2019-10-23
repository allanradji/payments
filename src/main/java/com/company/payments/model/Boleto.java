package com.company.payments.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

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
public class Boleto implements Serializable{

	private static final long serialVersionUID = 5876758140407296009L;
	
	public static final String NUMBER_EXAMPLE = "23790.50400 41991.022231 38008.109209 5 80530000019900";
	
	@Id
    @EqualsAndHashCode.Include
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="boleto_id")
	private Long id;
	
	@NotEmpty
	private String number;

}
