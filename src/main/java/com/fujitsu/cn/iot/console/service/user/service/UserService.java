package com.fujitsu.cn.iot.console.service.user.service;

import com.fujitsu.cn.iot.console.model.sys.User;
import com.fujitsu.cn.iot.console.service.user.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Mark on 2017/3/28.
 */
@Service
public class UserService {
    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserDao userDao;

    public User queryByUsrCd(String userCode){

        return this.userDao.queryByUsrCd(userCode);
    }
}
