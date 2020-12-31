package com.wah.commons.security.response.code;

public interface ResponseCode{

    //成功
    int SUCCESS = 200;
    //失败
    int FAIL    = 500;

    //参数异常
    int ILLEGAL_ARGUMENT = 10001;
    //禁止访问
    int FORBIDDEN_ERROR  = 10003;
}
