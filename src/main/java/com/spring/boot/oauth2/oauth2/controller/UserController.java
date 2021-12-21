package com.spring.boot.oauth2.oauth2.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* @Description:    用户管理控制类
* @Author:         tan_yi
* @CreateDate:     2021/12/2 22:37
* @UpdateUser:     tan_yi
* @UpdateDate:     2021/12/2 22:37
* @UpdateRemark:   修改内容
* @Version:        1.0
* @company:        newLand
*/
@RestController
@RequestMapping("/user")
public class UserController  {


    @RequestMapping("/getCurrentUser")
    public Object getCurrentUser(Authentication authentication) {
        System.out.println("用户控制类");
        return authentication.getPrincipal();
    }
}
