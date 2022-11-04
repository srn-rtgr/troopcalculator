package de.goodgames.army.calculator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IllegalArmySizeException extends IllegalArgumentException {
    public IllegalArmySizeException(String message){
        super(message);
    }
}
