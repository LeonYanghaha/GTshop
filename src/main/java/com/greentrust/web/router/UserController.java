package com.greentrust.web.router;
import java.util.concurrent.Future;
import com.greentrust.entity.Res;
import com.greentrust.entity.User;
import com.greentrust.job.Job;
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
    private Job job ;

    @Autowired
    private RedisUtil redisUtil ;
    @PostMapping("/testexception")
    public Res testException() throws Exception{

        // userService.testException();    //这句话抛出异常了，所以之后的代码没有执行
        // System.out.println("df");
        System.out.println(redisUtil.get("5f58ffca10e806ca7459b656f5a1b19e"));
        System.out.println("1234567890");
        System.out.println(1);



         Future<Boolean>  aa = job.asynvJob();  // 通过 Future 来判断异步的代码是否执行结束
         while (aa.isDone()){
             System.out.println("12345");
             break;
         }


        System.out.println(3);
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
