package com.wah.commons.security.response.code;

public interface ResponseCode{

    //成功
    int SUCCESS = 200;
    //失败
    int FAIL    = 500;

    //参数异常
    int ILLEGAL_ARGUMENT  = 50001;
    //持久化异常
    int DATA_ACCESS_ERROR = 50002;
    //禁止访问
    int FORBIDDEN_ERROR   = 50003;
}
