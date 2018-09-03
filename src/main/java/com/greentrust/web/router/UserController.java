package com.greentrust.web.router;

import com.greentrust.entity.Res;
import com.greentrust.entity.User;
import com.greentrust.service.UserService;
import com.greentrust.utils.RedisUtil;
import com.greentrust.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService ;

    @Autowired
    private RedisUtil redisUtil ;
    @PostMapping("/testexception")
    public Res testException() throws Exception{

        // userService.testException();    //这句话抛出异常了，所以之后的代码没有执行
        // System.out.println("df");
        System.out.println(redisUtil.get("5f58ffca10e806ca7459b656f5a1b19e"));
        System.out.println("1234567890");
        return Util.getSuccessRes(redisUtil.get("age"));
    }


    @PostMapping("/createuser")
    public Res createUser(@Validated User user , BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return Util.getErrorRes(bindingResult.getFieldError().getDefaultMessage(),null);
        }
        userService.saveUserToRedis(user);
        return Util.getSuccessRes(user);
    }

    @GetMapping("/getuserlist/{len}")
    public Res getUserList(@PathVariable("len") Integer len){
        List<User> userList = userService.getUserList(len);

        if(userList.size()>=1){
            return Util.getSuccessRes(userList);
        }else{
            return Util.getErrorRes("none",null);
        }
    }
}
