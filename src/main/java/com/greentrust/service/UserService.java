package com.greentrust.service;

import com.greentrust.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:
 * @author:Yangk.
 * @create:2018-04-02 19:01
 */
//@service
public interface  UserService {


//    User getUserById(Integer id);

    void testException() throws Exception;

    boolean saveUserToRedis (User user);

    User login(String usphone , String uspassword);

    int updateUserLastTime(Integer usid);

    int regist(String usname , String realUspassword , String usphone);

    List<User> getUserList(Integer listLeng);

//    public List<User> getUserList();
//
//    public int add(User user);
//
//    public int update(Integer id, User user);
//
//    public int delete(Integer id);


}
