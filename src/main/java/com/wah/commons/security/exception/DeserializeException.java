package com.wah.commons.security.exception;

import java.text.MessageFormat;

public class DeserializeException extends UtilsException{

    public DeserializeException(){
        super();
    }

    public DeserializeException(String message){
        super(message);
    }

    public DeserializeException(Throwable cause){
        super(cause);
    }

    public DeserializeException(String message, Throwable cause){
        super(message, cause);
    }

    public DeserializeException(String message, Object... args){
        super(MessageFormat.format(message, args));
    }

    public DeserializeException(Throwable cause, String message, Object... args){
        super(MessageFormat.format(message, args), cause);
    }
}
