package com.wah.commons.security.exception;

import java.text.MessageFormat;

public class KeyPairGenerateException extends Exception{

    public KeyPairGenerateException(){
        super();
    }

    public KeyPairGenerateException(String message){
        super(message);
    }

    public KeyPairGenerateException(Throwable cause){
        super(cause);
    }

    public KeyPairGenerateException(String message, Throwable cause){
        super(message, cause);
    }

    public KeyPairGenerateException(String message, Object... args){
        super(MessageFormat.format(message, args));
    }

    public KeyPairGenerateException(Throwable cause, String message, Object... args){
        super(MessageFormat.format(message, args), cause);
    }
}
