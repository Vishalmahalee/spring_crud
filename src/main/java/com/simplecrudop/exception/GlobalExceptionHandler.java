package com.simplecrudop.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFound (ResourceNotFoundException ex){

        Map<String, Object> error = new HashMap<>();
        error.put("timeStamp", LocalDateTime.now());
        error.put("message",ex.getMessage());
        error.put("status", HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    // handled the generic exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGenericException(Exception ex){
        Map<String,Object> error = new HashMap<>();
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        if (ex instanceof NullPointerException){
            status=HttpStatus.INTERNAL_SERVER_ERROR;
        } else if (ex instanceof ArithmeticException) {
            status=HttpStatus.BAD_REQUEST;
        } else if (ex instanceof IllegalArgumentException) {
            status= HttpStatus.BAD_REQUEST;
        }
        error.put("timestamp",LocalDateTime.now());
        error.put("message",ex.getMessage());
        error.put("exception",ex.getClass().getSimpleName());
        error.put("status",status);
        return new ResponseEntity<>(error,status);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationErrors(MethodArgumentNotValidException ex){

        Map<String, Object> error = new HashMap<>();
        error.put("timestamp", LocalDateTime.now());
        error.put("status", HttpStatus.BAD_REQUEST.value());

        Map<String, String> validateError = new HashMap<>();

        ex.getBindingResult()
                .getFieldErrors()
                .forEach(err -> validateError.put(err.getField(), err.getDefaultMessage()));
        error.put("errors", validateError);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
