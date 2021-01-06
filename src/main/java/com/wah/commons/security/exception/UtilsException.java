package com.wah.commons.security.exception;

import java.text.MessageFormat;

public class UtilsException extends Exception{

    public UtilsException(){
        super();
    }

    public UtilsException(String message){
        super(message);
    }

    public UtilsException(Throwable cause){
        super(cause);
    }

    public UtilsException(String message, Throwable cause){
        super(message, cause);
    }

    public UtilsException(String message, Object... args){
        super(MessageFormat.format(message, args));
    }

    public UtilsException(Throwable cause, String message, Object... args){
        super(MessageFormat.format(message, args), cause);
    }
}
