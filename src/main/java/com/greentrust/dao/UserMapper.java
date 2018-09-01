package com.greentrust.dao;

import com.greentrust.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @description:
 * @author:Yangk.
 * @create:2018-04-02 18:58
 */

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user  LIMIT 0,#{listLeng}")
    List<User> getUserList(@Param("listLeng") Integer listLeng);


//    @Insert("INSERT INTO greenuser ( USNAME , USLASTTIME , USREGTIME , USPASSWORD , USPHONE )VALUES(#{usname},NOW(),NOW(),#{uspassword},#{usphone})")
//    int regist(@Param("usname")String usname , @Param("uspassword")String uspassword ,@Param("usphone")String usphone);
//
//    @Select("SELECT USID,USNAME,USLASTTIME,USREGTIME,USPASSWORD,USSTATUS,USPHONE FROM greenuser  WHERE USPHONE = #{usphone} AND USPASSWORD = #{uspassword} LIMIT 0,1")
//    User login(@Param("usphone")String usphone , @Param("uspassword")String uspassword);
//
//
//    @Update("UPDATE greenuser SET USLASTTIME = NOW() WHERE USID = #{usid} ")
//    int updateUserLastTime( Integer usid);

//    @Insert("insert into tb_user(username, age, ctm) values(#{username}, #{age}, now())")
//    public int add(User user);
//
//    @Update("UPDATE tb_user SET username = #{user.username} , age = #{user.age} WHERE id = #{id}")
//    public int update(@Param("id") Integer id, @Param("user") User user);
//
//    @Delete("DELETE from tb_user where id = #{id} ")
//    public int delete(Integer id);
}