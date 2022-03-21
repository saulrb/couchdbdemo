package org.studying.couchdb.couchdbdemo.rest;

import com.couchbase.client.core.error.DocumentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.studying.couchdb.couchdbdemo.dto.APIErrorDto;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class APIExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationError(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        FieldError fieldError = bindingResult.getFieldError();
        String defaultMessage = fieldError.getDefaultMessage();
        return new ResponseEntity<>(new APIErrorDto("VALIDATION_FAILED", defaultMessage),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> constraintViolationException(ConstraintViolationException ex) {
        String violationExceptions = ex.toString();
        return new ResponseEntity<>(new APIErrorDto("VALIDATION_FAILED", violationExceptions),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DocumentNotFoundException.class)
    public ResponseEntity<?> handleValidationError(DocumentNotFoundException ex) {
        String defaultMessage = ex.getLocalizedMessage();
        return new ResponseEntity<>(new APIErrorDto("DOCUMENT_NOT_FOUND", defaultMessage),HttpStatus.NOT_FOUND);
    }

}
