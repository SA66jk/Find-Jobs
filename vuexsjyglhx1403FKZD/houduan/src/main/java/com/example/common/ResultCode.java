package com.example.common;

public enum ResultCode {
    SUCCESS("0", "success"),
    ERROR("-1", "系统异常"),
    PARAM_ERROR("1001", "参数异常"),
    USER_EXIST_ERROR("2001", "Job Seekers已存在"),
    USER_ACCOUNT_ERROR("2002", "The account number or password is incorrect"),
    USER_NOT_EXIST_ERROR("2003", "未找到Job Seekers"),
    ORDER_PAY_ERROR("3001", "库存不足，下单失败"),
    PARAM_LOST_ERROR("2004", "参数缺失"),
    PARAM_PASSWORD_ERROR("2005", "The original password was entered incorrectly"),
    ;

    public String code;
    public String msg;

    ResultCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
