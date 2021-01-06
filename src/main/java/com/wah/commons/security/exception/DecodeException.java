package com.wah.commons.security.exception;

import java.text.MessageFormat;

public class DecodeException extends UtilsException{

    public DecodeException(){
        super();
    }

    public DecodeException(String message){
        super(message);
    }

    public DecodeException(Throwable cause){
        super(cause);
    }

    public DecodeException(String message, Throwable cause){
        super(message, cause);
    }

    public DecodeException(String message, Object... args){
        super(MessageFormat.format(message, args));
    }

    public DecodeException(Throwable cause, String message, Object... args){
        super(MessageFormat.format(message, args), cause);
    }
}
