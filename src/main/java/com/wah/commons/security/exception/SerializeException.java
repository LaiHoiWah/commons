package com.wah.commons.security.exception;

import java.text.MessageFormat;

public class SerializeException extends UtilsException{

    public SerializeException(){
        super();
    }

    public SerializeException(String message){
        super(message);
    }

    public SerializeException(Throwable cause){
        super(cause);
    }

    public SerializeException(String message, Throwable cause){
        super(message, cause);
    }

    public SerializeException(String message, Object... args){
        super(MessageFormat.format(message, args));
    }

    public SerializeException(Throwable cause, String message, Object... args){
        super(MessageFormat.format(message, args), cause);
    }
}
