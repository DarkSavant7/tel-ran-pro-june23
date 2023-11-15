package de.telran.market.web;

import de.telran.market.dto.ErrorDto;
import de.telran.market.error.ProductNotFoundException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class SmartExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorDto> handleValidationExceptions(
      MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult().getAllErrors().forEach(error -> {
      String fieldName = ((FieldError) error).getField();
      String errorMessage = error.getDefaultMessage();
      errors.put(fieldName, errorMessage);
    });
    log.error("Got validation exception: {}", errors);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDto("Validation error", errors.toString()));
  }

  @ExceptionHandler(ProductNotFoundException.class)
  ResponseEntity<ErrorDto> handleProductNotFoundException(ProductNotFoundException exception) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(new ErrorDto("Error!", exception.getMessage()));
  }

  @ExceptionHandler(SQLException.class)
  ResponseEntity<ErrorDto> handleProductNotFoundException(SQLException exception) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(new ErrorDto("Error!", "Something went wrong!"));
  }

  @ExceptionHandler(Throwable.class)
  ResponseEntity<ErrorDto> handleUnhandled(Throwable throwable) {
    log.error("Critical error:", throwable);
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(new ErrorDto("Error!", "Something went wrong"));
  }
}
