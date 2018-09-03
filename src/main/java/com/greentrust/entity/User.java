package com.greentrust.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class User {

    @Min(3)
    @Max(999)
    @NotNull(message = "id is not null")
    private Integer usid ;
    @NotNull(message = "usname is not null")
    @JsonInclude(JsonInclude.Include.NON_NULL) //如果这个字段为空，那么返回的json中不会包含该字段
    private String usname ;

    // 这个注解可以让返回到客户端的对象中不包括改字段。
    // 这个注解很有用，我在写nodejs的时候，为了实现这个功能，是自己写了一个中间件去实现的
    @JsonIgnore
    @NotNull(message = "phone number is null")
    private String usphone ;


    public User(Integer usid, String usname, String usphone) {
        this.usid = usid;
        this.usname = usname;
        this.usphone = usphone;
    }

    @Override
    public String toString() {
        return "{" +
                "usid='" + usid + '\'' +
                ", usname='" + usname + '\'' +
                ", usphone='" + usphone + '\'' +
                '}';
    }

    public User() {
    }

    public Integer getUsid() {

        return usid;
    }

    public void setUsid(Integer usid) {

        this.usid = usid;
    }

    public String getUsname() {
        return usname;
    }

    public void setUsname(String usname) {
        this.usname = usname;
    }

    public String getUsphone() {
        return usphone;
    }

    public void setUsphone(String usphone) {
        this.usphone = usphone;
    }
}
