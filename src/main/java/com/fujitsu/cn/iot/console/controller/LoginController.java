package com.fujitsu.cn.iot.console.controller;

import com.fujitsu.cn.iot.console.common.utils.CodeUtil;
import com.fujitsu.cn.iot.console.common.utils.GlobalConstant;
import com.fujitsu.cn.iot.console.model.sys.User;
import com.fujitsu.cn.iot.console.service.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by mark on 2017/5/4.
 *
 * login
 */
@RestController
@RequestMapping(value = "/config/v1")
public class LoginController {

    @Autowired
    UserService userService;



    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(User userVO , HttpServletRequest request, HttpServletResponse response) {


        //查询
        User user = this.userService.queryByUsrCd(userVO.getUsercode());

        if (user == null)
        {

            return "用户不存在";

        } else if (user.getStatus() == GlobalConstant.CNST_USR_STAT_1)
        {

            return "用户被禁用";

        }

        String password = CodeUtil.encryptBase64(userVO.getPassword()
                , GlobalConstant.BASE64_KEY);

        if (password.equals(user.getPassword())) {

            return "允许登陆";
        } else {
            return "密码不正确";
        }

    }


}
