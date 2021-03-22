package com.smk.inventory.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.PropertyValueException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;

//@Order(Ordered.LOWEST_PRECEDENCE)

@ControllerAdvice
@ResponseBody
public class InventoryExceptionHandler extends ResponseEntityExceptionHandler {

//	@ExceptionHandler(PropertyValueException.class)
	public ResponseEntity<?> propertyValueException(PropertyValueException ex, WebRequest request) {

		ErrorMessage message = new ErrorMessage(new Date(),
				ex.getPropertyName() + " PropertyValueException not set..........", request.getDescription(false));
		return new ResponseEntity<ErrorMessage>(message, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<?> handleDataIntegrityViolationException(DataIntegrityViolationException ex,
			WebRequest request) {

		ErrorMessage message = new ErrorMessage(new Date(),
				ex.getMessage() + " DataIntegrityViolationException not set.........", request.getDescription(false));
		return new ResponseEntity<ErrorMessage>(message, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		ErrorMessage message = new ErrorMessage(new Date(), ex.getMessage() + " handleTypeMismatch not set.........",
				request.getDescription(false));
		return new ResponseEntity<Object>(message, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(RecordNotFoundException ex, WebRequest request) {
		ErrorMessage message = new ErrorMessage(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
	}

//	@ExceptionHandler(InvalidFormatException.class)
	@ExceptionHandler(MismatchedInputException.class)
	public ResponseEntity<?> invalidFormatException(MismatchedInputException ex, WebRequest request) {

		ErrorMessage message = new ErrorMessage(new Date(),
				ex.getMessage() + " MismatchedInputException invalid data.......................",
				request.getDescription(false));
		return new ResponseEntity<ErrorMessage>(message, HttpStatus.BAD_REQUEST);
	}

	// @ExceptionHandler(NumberFormatException.class)
	public ResponseEntity<?> numberFormatException(NumberFormatException ex, WebRequest request) {
		ErrorMessage message = new ErrorMessage(new Date(),
				" " + ex.getMessage() + " numberFormatException data.......................",
				request.getDescription(false));
		return new ResponseEntity<ErrorMessage>(message, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<?> numberFormatException(IllegalArgumentException ex, WebRequest request) {
		ErrorMessage message = new ErrorMessage(new Date(),
				" " + ex.getMessage() + " IllegalArgumentException data.......................",
				request.getDescription(false));
		return new ResponseEntity<ErrorMessage>(message, HttpStatus.BAD_REQUEST);
	}

	// @ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<?> handleAllOtherErrors(HttpMessageNotReadableException ex, WebRequest request) {
		ErrorMessage message = new ErrorMessage(new Date(),
				ex.getMessage() + " HttpMessageNotReadableException errr.......................",
				request.getDescription(false));
		return new ResponseEntity<ErrorMessage>(message, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorMessage message = new ErrorMessage(new Date(),
				ex.getMessage() + " handleHttpMessageNotReadable errr.......................",
				request.getDescription(false));
		return new ResponseEntity<Object>(message, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<?> handleConstraintViolationException(ConstraintViolationException ex, WebRequest request) {
		ErrorMessage message = new ErrorMessage(new Date(),
				ex.getMessage() + " ConstraintViolationException errr.......................",
				request.getDescription(false));
		return new ResponseEntity<ErrorMessage>(message, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globalExceptionHandler(Exception ex, WebRequest request) {
		ErrorMessage message = new ErrorMessage(new Date(),
				ex.getMessage() + " globalExceptionHandler errr.......................", request.getDescription(false));
		return new ResponseEntity<ErrorMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);
	}

//	@Override
//	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//			HttpHeaders headers, HttpStatus status, WebRequest request) {
//
//		List<String> details = new ArrayList<String>();
//		details = ex.getBindingResult().getFieldErrors().stream()
//				.map(error -> error.getObjectName() + " : " + error.getDefaultMessage()).collect(Collectors.toList());
//
//		ErrorMessage message = new ErrorMessage(new Date(),
//				ex.getMessage() + " handleMethodArgumentNotValid errr.......................",
//				request.getDescription(false));
//		return new ResponseEntity<Object>(message, HttpStatus.BAD_REQUEST);
//	}

}
