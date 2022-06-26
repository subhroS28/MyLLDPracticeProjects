package org.subhro.exceptions;

public class SubscriptionDoesNotExistException extends RuntimeException{

    private static final long serialVersionUID = 3L;

    public SubscriptionDoesNotExistException(String errorMessage){
        super(errorMessage);
    }
}
