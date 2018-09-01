package com.greentrust.entity;

/**
 * @description:返回消息的实体类
 * @author:Yangk.
 * @create:2018-04-02 19:05
 */

public class JsonResult {

    /*
     * @description:  返回的状态值，200表示0k .. 500.服务端出错了    501，参数错误,502 查询结果为空
     * @author Yangk.
     * @date 2018/4/3 10:09
     */
    private Integer status = null;
    private String msg = null ;
    private Object result = null;


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "status='" + status + '\'' +
                ", result=" + result +
                ", msg='" + msg + '\'' +
                '}';
    }
}
