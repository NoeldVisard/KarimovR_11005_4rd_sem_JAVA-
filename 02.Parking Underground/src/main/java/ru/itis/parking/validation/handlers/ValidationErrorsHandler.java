package ru.itis.parking.validation.handlers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.itis.parking.validation.http.ValidationErrorDto;
import ru.itis.parking.validation.http.ValidationExceptionResponse;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ValidationErrorsHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<ValidationErrorDto> errors = new ArrayList<>();

        exception.getBindingResult().getAllErrors().forEach((error) ->{

            String errorMessage = error.getDefaultMessage();
            ValidationErrorDto errorDto = ValidationErrorDto.builder()
                    .message(errorMessage)
                    .build();

            if(error instanceof FieldError){
                String fieldName = ((FieldError) error).getField();
                errorDto.setField(fieldName);

            } else if(error instanceof ObjectError){
                String objectName = error.getObjectName();
                errorDto.setObject(objectName);
            }
            errors.add(errorDto);

        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ValidationExceptionResponse.builder()
                .errors(errors)
                .build());

    }
}
