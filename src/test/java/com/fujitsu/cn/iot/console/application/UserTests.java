package com.fujitsu.cn.iot.console.application;

import com.fujitsu.cn.iot.console.IotProjectApplication;
import com.fujitsu.cn.iot.console.mapper.UserMapper;
import com.fujitsu.cn.iot.console.model.sys.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	@Rollback
	public void findByName() throws Exception {
		User u = userMapper.queryByUsrCd("dev001");

		Assert.assertEquals(1, u.getId());
	}

}