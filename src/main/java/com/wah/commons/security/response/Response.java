package com.wah.commons.security.response;

import com.wah.commons.security.response.code.ResponseCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response<T>{

    private int     code;
    private String  msg;
    private Boolean success;
    private T       result;

    public Response(){

    }

    public Response(String msg){
        this.code    = ResponseCode.SUCCESS;
        this.msg     = msg;
        this.success = true;
    }

    public Response(String msg, T result){
        this.code    = ResponseCode.SUCCESS;
        this.msg     = msg;
        this.success = true;
        this.result  = result;
    }

    public Response(int code, String msg, Boolean success){
        this.code    = code;
        this.msg     = msg;
        this.success = success;
    }

    public Response(int code, String msg, Boolean success, T result){
        this.code    = code;
        this.msg     = msg;
        this.success = success;
        this.result  = result;
    }

    public Response success(String msg){
        this.code    = ResponseCode.SUCCESS;
        this.msg     = msg;
        this.success = true;

        return this;
    }

    public Response success(String msg, T result){
        this.code    = ResponseCode.SUCCESS;
        this.msg     = msg;
        this.success = true;
        this.result  = result;

        return this;
    }

    public Response success(int code, String msg){
        this.code    = code;
        this.msg     = msg;
        this.success = true;

        return this;
    }

    public Response success(int code, String msg, T result){
        this.code    = code;
        this.msg     = msg;
        this.success = true;
        this.result  = result;

        return this;
    }

    public Response fail(String msg){
        this.code    = ResponseCode.FAIL;
        this.msg     = msg;
        this.success = false;

        return this;
    }

    public Response fail(String msg, T result){
        this.code    = ResponseCode.FAIL;
        this.msg     = msg;
        this.success = false;
        this.result  = result;

        return this;
    }

    public Response fail(int code, String msg){
        this.code    = code;
        this.msg     = msg;
        this.success = false;

        return this;
    }

    public Response fail(int code, String msg, T result){
        this.code    = code;
        this.msg     = msg;
        this.success = false;
        this.result  = result;

        return this;
    }
}
