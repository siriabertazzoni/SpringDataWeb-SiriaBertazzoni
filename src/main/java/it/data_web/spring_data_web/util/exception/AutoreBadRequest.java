package it.data_web.spring_data_web.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class AutoreBadRequest extends RuntimeException {
    public AutoreBadRequest(){
    }
    public AutoreBadRequest(String message){
        super(message);
    }
}
