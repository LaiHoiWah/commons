package com.wah.commons.security.exception;

import java.text.MessageFormat;

public class SignatureException extends Exception{

    public SignatureException(){
        super();
    }

    public SignatureException(String message){
        super(message);
    }

    public SignatureException(Throwable cause){
        super(cause);
    }

    public SignatureException(String message, Throwable cause){
        super(message, cause);
    }

    public SignatureException(String message, Object... args){
        super(MessageFormat.format(message, args));
    }

    public SignatureException(Throwable cause, String message, Object... args){
        super(MessageFormat.format(message, args), cause);
    }
}
