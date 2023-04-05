package com.college_predict.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.college_predict.exception.CollegeNotFoundException;

@RestControllerAdvice
public class UserException {

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(CollegeNotFoundException.class)
	public Map<String,String> handleCollegeNotFound(CollegeNotFoundException ex)
	{
		Map<String,String> errorMap=new HashMap<>();
		
		errorMap.put("errorMessage", ex.getMessage());
		return errorMap;
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> handleValidException(MethodArgumentNotValidException ex)
	{
		Map<String,String> errorMap=new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(
				error -> {errorMap.put(error.getField(),error.getDefaultMessage());
				});
		return errorMap;
	}
	
//	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//	@ExceptionHandler(Exception.class)
//	public Map<String,String> handleAllTypeException(Exception ex)
//	{
//		Map<String, String> errorMap=new HashMap<>();
//		errorMap.put("errorMessage", "Sorry Something Went Wrong At Server Side");
//		
//		HttpStatus error = HttpStatus.INTERNAL_SERVER_ERROR;
//		errorMap.put("Status", String.valueOf(error));
//		
//		return errorMap;
//	}
}
