package com.greentrust.entity;

import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class User {

    @Min(3)
    @Max(999)
    @NotNull(message = "id is not null")
    private Integer usid ;
    @NotNull(message = "usname is not null")
    private String usname ;
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
