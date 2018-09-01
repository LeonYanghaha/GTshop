package com.greentrust.web.router;

import com.greentrust.entity.Res;
import com.greentrust.entity.User;
import com.greentrust.service.UserService;
import com.greentrust.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService ;
    @PostMapping("/testexception")
    public Res testException() throws Exception{

        userService.testException();
        return Util.getSuccessRes(null);
    }


    @PostMapping("/createuser")
    public Res createUser(@Validated User user , BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return Util.getErrorRes(bindingResult.getFieldError().getDefaultMessage(),null);
        }
        userService.saveUserToRedis(user);
        return Util.getSuccessRes(user);
    }

    @RequestMapping("/getuserlist/{len}")
    public Res getUserList(@PathVariable("len") Integer len){
        List<User> userList = userService.getUserList(len);

        if(userList.size()>=1){
            return Util.getSuccessRes(userList);
        }else{
            return Util.getErrorRes("none",null);
        }
    }
}
