package com.greentrust.web.router;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author:Yangk.
 * @create:2018-04-02 17:04
 */
@RestController
@RequestMapping("/other")
public class Common extends Cors {


    /*
     * @description:发送短信的router
     * @author Yangk.
     * @date 2018/4/8 11:36
     * @param  发送短信的手机号
     * @return
     */
    @PostMapping("/sendmsg")
    public String regist(@RequestParam(value="usphone") String usphone ,
                         @RequestParam(value="uspassword") String uspassword ,
                         @RequestParam(value="msgcode") String msgcode){



















        return "";
    }

}
