package lech.bartlomiej.contacts.ui;

import lech.bartlomiej.contacts.domain.commands.InvalidCommandException;
import lech.bartlomiej.contacts.domain.commands.ValidCommand;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandlers {

    private static final String APPLICATION_JSON = "application/json";

    @ExceptionHandler(InvalidCommandException.class)
    public ResponseEntity<ValidCommand.ValidationErrors> handleInvalidCommandException(InvalidCommandException ex) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.CONTENT_TYPE, APPLICATION_JSON);
        return new ResponseEntity<>(ex.getErrors(), httpHeaders, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
