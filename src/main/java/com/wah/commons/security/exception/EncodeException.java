package com.wah.commons.security.exception;

import java.text.MessageFormat;

public class EncodeException extends UtilsException{

    public EncodeException(){
        super();
    }

    public EncodeException(String message){
        super(message);
    }

    public EncodeException(Throwable cause){
        super(cause);
    }

    public EncodeException(String message, Throwable cause){
        super(message, cause);
    }

    public EncodeException(String message, Object... args){
        super(MessageFormat.format(message, args));
    }

    public EncodeException(Throwable cause, String message, Object... args){
        super(MessageFormat.format(message, args), cause);
    }
}
