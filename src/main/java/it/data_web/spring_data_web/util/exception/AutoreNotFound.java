package it.data_web.spring_data_web.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Autore non trovato")
public class AutoreNotFound extends RuntimeException{
    
}
