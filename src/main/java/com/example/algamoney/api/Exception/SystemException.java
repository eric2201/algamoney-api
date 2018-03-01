package com.example.algamoney.api.Exception;

public class SystemException extends InternalArchitectureException {

    public SystemException(String message) {
        super(message);
    }

    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }
}
