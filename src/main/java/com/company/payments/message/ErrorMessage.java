package com.company.payments.message;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ErrorMessage implements Serializable {

	private static final long serialVersionUID = -2247894498171833804L;

	private Integer code;

    @JsonProperty("code_description")
    private String codeDescription;

    private String message;
}