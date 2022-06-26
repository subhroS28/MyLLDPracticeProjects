package org.subhro.exceptions;

public class TopupDoesNotExistException extends RuntimeException{

    private static final long serialVersionUID = 4L;

    public TopupDoesNotExistException(String errorMessage){
        super(errorMessage);
    }
}
