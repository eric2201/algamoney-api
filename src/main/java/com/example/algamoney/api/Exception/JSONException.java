package com.example.algamoney.api.Exception;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class JSONException extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String messageUser = messageSource.getMessage("message.invalid", null, LocaleContextHolder.getLocale());
        String messageDev = ex.getCause().toString();
        List<Error> errors = Arrays.asList(new Error(messageUser, messageDev));
        return handleExceptionInternal(ex, errors, headers, HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<Error> errors = createListErrors(ex.getBindingResult());
        return handleExceptionInternal(ex, errors, headers, HttpStatus.BAD_REQUEST, request);
    }
    //BindingResult - Lista de todos os erros
    private List<Error> createListErrors(BindingResult bindingResult) {
        List<Error> errors = new ArrayList<>();
        String messageUser;
        String messageDev;
        //FieldError erros que podem ocorrer no bean (CategoryEntity)
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            messageUser = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
            messageDev = fieldError.toString();
            errors.add(new Error(messageUser, messageDev));

        }
        return errors;
    }
    //Trarar essas exceções Dado não encontrado no banco
    @ExceptionHandler({EmptyResultDataAccessException.class, EntityNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleEmptyResultDataAccessException (){
    }

    @Data
    public static class Error {

        private String messageUser;
        private String messageDev;

        public Error(String messageUser, String messageDev) {
            this.messageUser = messageUser;
            this.messageDev = messageDev;
        }

    }
}
