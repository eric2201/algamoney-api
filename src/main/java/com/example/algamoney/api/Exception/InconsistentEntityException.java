package com.example.algamoney.api.Exception;

public class InconsistentEntityException extends SystemException {

    public InconsistentEntityException(String message) {
        super(message);
    }

    public InconsistentEntityException(String message, Throwable cause) {
        super(message, cause);
    }

}
