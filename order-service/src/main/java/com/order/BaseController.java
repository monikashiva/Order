package com.order;

import java.util.HashMap;
import java.util.Map;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class BaseController {

	public BaseController() {
		super();
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleException(MethodArgumentNotValidException exp) {
		Map<String, String> errMsg= new HashMap<>();
		exp.getAllErrors().forEach(error -> {
			String fieldName=((FieldError)error).getField();
					String message=((FieldError)error).getDefaultMessage();
					errMsg.put(fieldName, message);
		});
		return errMsg;
	}

}