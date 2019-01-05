package br.com.devdojo.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Todo status dessa seção será NOT FOUND.
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    
    
    // Constructor ------------------------------------------------------------
    public ResourceNotFoundException(String message) {
        super(message);
    }
    
    
}
