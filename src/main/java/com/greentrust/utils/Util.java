package com.greentrust.utils;

import com.greentrust.entity.Res;
public class Util {


    public static Res getErrorRes(String info , Object object){

        return Util.getRes(-1,info,object);
    }

    public static Res getSuccessRes(Object object){
        return Util.getRes(0,"success",object);
    }

    public static Res getRes(Integer code , String info , Object object ){
        return new Res(code,info,object);
    }
}
