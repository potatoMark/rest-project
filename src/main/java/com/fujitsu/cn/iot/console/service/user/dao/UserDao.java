package com.fujitsu.cn.iot.console.service.user.dao;

import com.fujitsu.cn.iot.console.mapper.UserMapper;
import com.fujitsu.cn.iot.console.model.sys.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by Mark on 2017/3/28.
 */
@Repository
public class UserDao {
    private static final Logger LOG = LoggerFactory.getLogger(UserDao.class);

    @Autowired
    UserMapper userMapper;

    public User queryByUsrCd(String userCode){

        return this.userMapper.queryByUsrCd(userCode);
    }

}
