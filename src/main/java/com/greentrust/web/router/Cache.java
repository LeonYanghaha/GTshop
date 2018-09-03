package com.greentrust.web.router;

import com.greentrust.entity.Res;
import com.greentrust.entity.User;
import com.greentrust.service.UserService;
import com.greentrust.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cache")
public class Cache {

    @Autowired
    private UserService userService ;

    @GetMapping("/getuser")
    public Res getuser(){
        return Util.getSuccessRes(null);
    }

    @GetMapping("/saveuser")
    public Res saveuser(){
        User user = userService.getUserByID(2);
        return Util.getSuccessRes(user);
    }
}
