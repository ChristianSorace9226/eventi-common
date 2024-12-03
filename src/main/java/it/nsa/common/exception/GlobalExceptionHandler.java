package it.nsa.common.exception;

import it.nsa.common.response.GenericResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.management.InstanceAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<GenericResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<String> errors = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(e -> errors.add(e.getDefaultMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(GenericResponse.error("error", errors));
    }

    //TODO: gestire eccezioni di tipo EventException (distinzione tipo con switch su exceptionEnum)

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<GenericResponse> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(getError(ex));
    }

    @ExceptionHandler(InstanceAlreadyExistsException.class)
    public ResponseEntity<GenericResponse> handleInstanceAlreadyExistsException(InstanceAlreadyExistsException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(getError(ex));
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<GenericResponse> handleBadCredentialsException(BadCredentialsException ex) {
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(getError(ex));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GenericResponse> handleGeneralException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(getError(ex));
    }

    private GenericResponse getError(Exception ex) {
        List<String> errors = new ArrayList<>(1);
        errors.add(ex.getMessage());
        return GenericResponse.error("error", errors);
    }
}
