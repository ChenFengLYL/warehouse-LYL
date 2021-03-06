package com.ylu.warehouse.sys.controller;

import com.ylu.warehouse.sys.common.ActiverUser;
import com.ylu.warehouse.sys.common.ResultObj;
import com.ylu.warehouse.sys.common.WebUtils;
import com.ylu.warehouse.sys.domain.Loginfo;
import com.ylu.warehouse.sys.service.LoginfoService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@RestController
@RequestMapping("login")
public class LoginController {
    @Autowired
    private LoginfoService loginfoService;
    @RequestMapping("login")
    public ResultObj login(String loginname,String pwd){
        Subject subject = SecurityUtils.getSubject();
        AuthenticationToken token = new UsernamePasswordToken(loginname,pwd);
        try {
            subject.login(token);
            ActiverUser activerUser = (ActiverUser) subject.getPrincipal();
            WebUtils.getHttpSession().setAttribute("user",activerUser.getUser());
            //记录登录日志
            Loginfo entity =  new Loginfo();
            entity.setLoginname(activerUser.getUser().getName()+"-"+activerUser.getUser().getLoginname());
            entity.setLoginip(WebUtils.getRequest().getRemoteAddr());
            entity.setLogintime(new Date());
            loginfoService.save(entity);
            return ResultObj.LOGIN_SUCCESS;
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return ResultObj.LOGIN_ERROR_PASS;
        }
    }
}
