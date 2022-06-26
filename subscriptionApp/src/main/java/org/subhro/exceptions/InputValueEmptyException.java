package org.subhro.exceptions;

public class InputValueEmptyException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public InputValueEmptyException(String errorMessage){
        super(errorMessage);
    }
}
