package de.telran.market.web;

import de.telran.market.dto.ErrorDto;
import de.telran.market.error.ProductNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class SmartExceptionHandler {

  @ExceptionHandler(ProductNotFoundException.class)
  ResponseEntity<ErrorDto> handleProductNotFoundException(ProductNotFoundException exception) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(new ErrorDto("Error!", exception.getMessage()));
  }

  @ExceptionHandler(Throwable.class)
  ResponseEntity<ErrorDto> handleUnhandled(Throwable throwable) {
    log.error("Critical error:", throwable);
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(new ErrorDto("Error!", "Something went wrong"));
  }
}