package com.greentrust.service.impl;

import com.greentrust.dao.UserMapper;
import com.greentrust.exception.UserException;
import com.greentrust.service.UserService;
import com.greentrust.entity.User;
import com.greentrust.utils.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author:Yangk.
 * @create:2018-04-02 19:03
 */
@Component
public class UserServiceimpl  implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    @Resource
    private RedisTemplate<String, String> rt;

    @Override
    public void testException() throws UserException{
        throw new UserException("df");
    }

    @Override
    public boolean saveUserToRedis(User user) {

        ValueOperations<String,String> vo = rt.opsForValue();
        vo.set(StrUtil.strToMD5(user.toString()),user.toString());
        return true;
    }

    public int regist( String usname , String realUspassword , String usphone){
        String uspassword = StrUtil.strToMD5(realUspassword);
        return 0 ;//userMapper.regist(usname , uspassword , usphone);
    }

    @Override
    public List<User> getUserList(Integer listLeng) {
        return userMapper.getUserList(listLeng);
    }

    /*
     * @description:用户的登录
     * @author Yangk. 
     * @date 2018/4/8 13:29
     * @param   
     * @return   
     */
    @Override
    public User login(String usphone , String realUspassword){

        String uspassword = StrUtil.strToMD5(realUspassword) ;
        return null ;//userMapper.login(usphone,uspassword) ;
    }
    /*   
     * @description:更新用户的最新登录时间
     * @author Yangk. 
     * @date 2018/4/8 13:28
     * @param   
     * @return   
     */
    @Override
    @Transactional
    public int updateUserLastTime(Integer usid ){
        return 0;//userMapper.updateUserLastTime(usid);
    }

//    @Override
//    @Transactional
//    public User getUserById(Integer id) {
//
//
//        //测试事物
////        Integer temp1 = userMapper.add(new User("TTT",18));
////        Integer temp2 = userMapper.add(new User("TTT",1900));
////        Integer temp3 = userMapper.add(new User("TTT",20));
//
////        System.out.println(temp1+"++++++"+temp2+"-------"+temp3);
//        return userMapper.getUserById(id);
//    }



//    @Override
//    public List<User> getUserList() {
//        return userMapper.getUserList();
//    }
//
//    @Override
//    public int add(User user){
//        return userMapper.add(user);
//    }
//
//    @Override
//    public int update(Integer id, User user) {
//
//        return userMapper.update(id, user);
//    }
//
//    @Override
//    public int delete(Integer id) {
//
//        return userMapper.delete(id);
//    }

}
