package com.capgemini.employeepayrollapp.exceptions;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.capgemini.employeepayrollapp.dto.ResponseDTO;

@ControllerAdvice
public class EmployeePayrollExceptionHandler{
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
		List<ObjectError> errList = exception.getBindingResult().getAllErrors();
		List<String> errMessages = errList.stream()
				            .map(error -> error.getDefaultMessage()).collect(Collectors.toList());
		ResponseDTO respDTO = new ResponseDTO("Exception occured", errMessages);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.BAD_REQUEST);	
	}
	@ExceptionHandler(EmployeeException.class)
	public ResponseEntity<ResponseDTO> handleEmployeeException (EmployeeException exception){
		ResponseDTO respDTO = new ResponseDTO("Exception occured", exception.getMessage());
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.BAD_REQUEST);	
	}
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ResponseDTO> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception){
		ResponseDTO respDTO = new ResponseDTO("Exception occured", "Should have date in the format dd MMM yyyy");
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.BAD_REQUEST);
	}
}
