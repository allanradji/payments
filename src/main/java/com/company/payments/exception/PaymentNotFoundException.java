package com.company.payments.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class PaymentNotFoundException extends ResourceException {

	private static final long serialVersionUID = -1701398787077915771L;
	
	private Long idPayment;

    public PaymentNotFoundException(Long idPayment) {
        super(HttpStatus.NOT_FOUND, "pagamento.nao.existente");
        this.idPayment = idPayment;
    }
}
