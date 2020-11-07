package com.gofurther.emissora.config.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException.Unauthorized;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(value = {IllegalArgumentException.class})
  protected ResponseEntity<Object> handleConflict(RuntimeException runtimeException,
      WebRequest webRequest) {
    Map<String, String> message = Map.of("message", runtimeException.getMessage());

    return handleExceptionInternal(runtimeException, message, new HttpHeaders(),
        HttpStatus.CONFLICT, webRequest);
  }

  @ExceptionHandler(value = {RuntimeException.class})
  protected ResponseEntity<Object> outroConflict(RuntimeException runtimeException,
      WebRequest webRequest) {
    Map<String, String> message = Map.of("message", runtimeException.getMessage());

    return handleExceptionInternal(runtimeException, message, new HttpHeaders(),
        HttpStatus.CONFLICT, webRequest);
  }
}
