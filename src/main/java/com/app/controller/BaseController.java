package com.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.app.api.error.ErrorDto;
import com.app.api.error.MyException;
import com.app.util.ExceptionUtils;

public class BaseController {

	@ExceptionHandler(MyException.class)
	public ResponseEntity<ErrorDto> handleMyException(MyException e) {
		ErrorDto errorDto = ErrorDto.builder().message(e.getMessage()).build();
		return new ResponseEntity<ErrorDto>(errorDto, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDto> handleException(Exception e) {
		ErrorDto errorDto = ErrorDto.builder().message(ExceptionUtils.getMessageCause(e)).build();
		return new ResponseEntity<ErrorDto>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
