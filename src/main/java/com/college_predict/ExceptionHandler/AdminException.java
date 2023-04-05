package com.college_predict.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.college_predict.exception.FileFormatWrongException;

@RestControllerAdvice
public class AdminException {

	@ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
	@ExceptionHandler(FileFormatWrongException.class)
	public Map<String,String> handleFileFormatWrong(FileFormatWrongException ex)
	{
		Map<String,String> errorMap=new HashMap<>();
		
		errorMap.put("errorMessage", ex.getMessage());
		return errorMap;
	}
	
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public Map<String,String> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex)
	{
		Map<String,String> errorMap=new HashMap<>();
		errorMap.put("errorMessage", ex.getMessage());
		
		return errorMap;
	}
}
