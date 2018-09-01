package com.greentrust.exception;

public class UserException extends RuntimeException {
    private Integer code;

    public UserException(String strinfo){

        super(strinfo);
        this.code = -1;
    }
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }

}
