package com.greentrust.web.router;
import java.util.concurrent.Future;
import com.greentrust.entity.Res;
import com.greentrust.entity.User;
import com.greentrust.job.Job;
import com.greentrust.service.UserService;
import com.greentrust.utils.JWT;
import com.greentrust.utils.RedisUtil;
import com.greentrust.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    // 使用jwt的方式
    @GetMapping("/getjwt")
    public Res testjwt(){
//        HttpSession session = request.getSession();
//        if (session.getAttribute("user") == null) {
//            session.setAttribute("user", "zhangsan");
//            System.out.println("不存在session");
//        } else {
//            System.out.println("存在session");
//        }
//
//        List<User> list = userService.getUserList(4);
        List<User> list = userService.getUserList(2);
        User user = list.get(0);
        System.out.println(user);

        String token = JWT.sign(user,60L* 1000L* 30L);
        System.out.println(token);

        // System.out.println(token);

        User users = JWT.unsign(token,User.class);
        users.setUsphone(token);
        System.out.println(users);
        return  Util.getSuccessRes(users);

    }

    // 使用session的方式
    @GetMapping("/getsession")
    public Res testSesion(HttpServletRequest request){
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            session.setAttribute("user", "zhangsan");
            System.out.println("不存在session");
        } else {
            System.out.println("存在session");
        }

        List<User> list = userService.getUserList(4);
        return  Util.getSuccessRes(list);

    }

    @PostMapping("/testexception")
    public Res testException() throws Exception{

        // userService.testException();    //这句话抛出异常了，所以之后的代码没有执行
        // System.out.println("df");
        System.out.println(redisUtil.get("5f58ffca10e806ca7459b656f5a1b19e"));
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
