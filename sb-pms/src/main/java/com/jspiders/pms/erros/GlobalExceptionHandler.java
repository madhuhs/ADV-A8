package com.jspiders.pms.erros;

import com.jspiders.pms.dto.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ErrorResponse> handleArithmeticException
            (ArithmeticException ae)
    {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("You tried to divide a number by 0");
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException
            (IllegalArgumentException ex){

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(DuplicateUserException.class)
    public ResponseEntity<ErrorResponse> handleDuplicateUserException
            (DuplicateUserException ex){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.badRequest().body(errorResponse);
    }



    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, List<String>>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<String> errors =
                ex.getBindingResult().getFieldErrors()
                .stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
        return new ResponseEntity<>(getErrorsMap(errors), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    private Map<String, List<String>> getErrorsMap(List<String> errors) {
        Map<String, List<String>> errorResponse = new HashMap<>();
        errorResponse.put("errors", errors);
        return errorResponse;
    }

}
