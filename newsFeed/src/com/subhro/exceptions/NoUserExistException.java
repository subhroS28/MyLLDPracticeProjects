package com.subhro.exceptions;

public class NoUserExistException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public NoUserExistException(String message){
        super(message);
    }
}
