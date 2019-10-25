package com.company.payments.message;

import java.io.Serializable;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SourceMessage implements Serializable{

	private static final long serialVersionUID = -6432927680816851812L;
	
	private final MessageSource messageSource;

    public String getMessage(String key, Object... params) {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage(key, params, locale);
	}
}
