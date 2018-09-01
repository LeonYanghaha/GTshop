package com.greentrust.handler;

import com.greentrust.entity.Res;
import com.greentrust.exception.UserException;
import com.greentrust.utils.Util;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Res handle(Exception e) {
        if (e instanceof UserException) {
            UserException userException = (UserException) e;
            return Util.getErrorRes(userException.getMessage(),null);  // ResultUtil.error(girlException.getCode(), girlException.getMessage());
        }else {
            return Util.getErrorRes("系统异常",null);
        }
    }
}
