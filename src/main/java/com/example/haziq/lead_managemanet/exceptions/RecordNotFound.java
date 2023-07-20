package com.example.haziq.lead_managemanet.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class RecordNotFound extends RuntimeException {
  public RecordNotFound(String message) {
    super(message);
  }
}
