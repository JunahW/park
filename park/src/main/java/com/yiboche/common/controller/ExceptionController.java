package com.yiboche.common.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 异常统一处理
 * 
 * @author JunahW
 *
 */
@ControllerAdvice
public class ExceptionController {
	@ResponseStatus()
	@ExceptionHandler()
	public ResponseEntity<Object> handleCustomerException() {
		return null;

	}

}
