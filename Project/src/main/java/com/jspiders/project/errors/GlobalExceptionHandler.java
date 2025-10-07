package com.jspiders.project.errors;

import com.jspiders.project.data.dto.CommonResponse;
import com.jspiders.project.utils.ResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<CommonResponse> noSuchElementExceptionHandler
                                          (NoSuchElementException ex)
    {
       return ResponseUtil.getErrorResponse("Data not found",null);
    }
}





