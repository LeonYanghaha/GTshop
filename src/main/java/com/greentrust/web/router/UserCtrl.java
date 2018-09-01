package com.greentrust.web.router;

import com.greentrust.entity.JsonResult;
import com.greentrust.entity.User;
import com.greentrust.service.UserService;
import com.greentrust.utils.JWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpSession;

/**
 * @description:
 * @author:Yangk.
 * @create:2018-04-02 16:40
 */
@RestController
@RequestMapping("/user")
public class UserCtrl extends Cors {



    @Autowired
    private UserService userService ;
    private static final Logger logger = LogManager.getLogger(UserCtrl.class);
    /*
     * @description:测试使用的路由
     * @author Yangk.
     * @date 2018/4/3 10:16
     * @param
     * @return
     */
    @RequestMapping(value = "test/{id}", method = RequestMethod.GET)
    public ResponseEntity/*<JsonResult>*/ getUserById (@PathVariable(value = "id") Integer id,
                                                   HttpSession httpSession){

        httpSession.setAttribute("user", "helloword");
        return ResponseEntity.ok(httpSession.getAttribute("user"));

//        JsonResult r = new JsonResult();
//        logger.info("info execute index method");
//        logger.warn("warn execute index method");
//        logger.error("error execute index method");
//        try {
//            User user = userService.getUserById(id);
//            r.setResult(user);
//            r.setStatus(200);
//            r.setMsg("ok");
//        } catch (Exception e) {
//            r.setResult(e.getClass().getName() + ":" + e.getMessage());
//            r.setStatus(500);
//            e.printStackTrace();
//        }
//        return ResponseEntity.ok(r);
    }

    /*
     * @description:用户登录
     * @author Yangk.
     * @date 2018/4/2 17:00
     * @param username 用户名，也就是用户的手机号，password 密码
     * @return
     */
    @PostMapping("login")
    public ResponseEntity login(@RequestParam(value="username") String usphone,
                                @RequestParam(value="password") String uspassword,
                                HttpSession httpSession){
//
//        JsonResult r = new JsonResult();
//
//        if(usphone == null || usphone.equals("") || uspassword ==null || uspassword.equals("") ){
//            r.setMsg("参数不能为空");
//            r.setStatus(501);
//            return ResponseEntity.ok(r);
//        }
//
//
//        User user = userService.login(usphone,uspassword);
//        if(user == null){
//            r.setMsg("用户名或者密码错误");
//            r.setStatus(502);
//            return ResponseEntity.ok(r);
//        }
//        //登录成功之后，需要将用户的信息存储。其次 更新用户的最新登录时间
//        //更新用户的最新登录时间
//        int effectRow = userService.updateUserLastTime(user.getUsid());
//
//
//        String token = JWT.sign(user, 60L* 1000L* 30L);





        JsonResult r = new JsonResult();

        if(usphone == null || usphone.equals("") || uspassword ==null || uspassword.equals("") ){
            r.setMsg("参数不能为空");
            r.setStatus(501);
            return ResponseEntity.ok(r);
        }


        User user = userService.login(usphone,uspassword);
        if(user == null){
            r.setMsg("用户名或者密码错误");
            r.setStatus(502);
            return ResponseEntity.ok(r);
        }
        //登录成功之后，需要将用户的信息存储。其次 更新用户的最新登录时间
        //更新用户的最新登录时间
        int effectRow = userService.updateUserLastTime(user.getUsid());
        //session


        if(effectRow==1){
            r.setMsg("success");
            r.setStatus(200);
            r.setResult(user);
            return ResponseEntity.ok(r);
        }else{
            r.setMsg("error");
            r.setStatus(500);
            return ResponseEntity.ok(r);
        }
    }
    
    /*   
     * @description:用户注册的路由
     * @author Yangk. 
     * @date 2018/4/2 16:56
     * @param   
     * @return   
     */
    @PostMapping("regist")
    public ResponseEntity regist(@RequestParam(value="username") String usphone,
                                 @RequestParam(value="password") String uspassword){

        JsonResult r = new JsonResult();

        if(usphone == null || usphone.equals("") || uspassword ==null || uspassword.equals("") ){
            r.setMsg("参数不合法");
            r.setStatus(501);
            return ResponseEntity.ok(r);
        }

        Integer effectRow = userService.regist(usphone , uspassword , usphone);

        if(effectRow==1){
            r.setMsg("success");
            r.setStatus(200);
            return ResponseEntity.ok(r);
        }else{
            r.setMsg("error");
            r.setStatus(500);
            return ResponseEntity.ok(r);
        }
    }
}