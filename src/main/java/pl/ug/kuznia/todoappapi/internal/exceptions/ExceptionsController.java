package pl.ug.kuznia.todoappapi.internal.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class ExceptionsController {

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<Map<String, String>> resourceNotFound(ResourceNotFoundException exception){
        Map<String, String> response = Map.of("message", exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

}
