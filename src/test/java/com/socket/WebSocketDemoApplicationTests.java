package com.socket;

import com.socket.domain.User;
import com.socket.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebSocketDemoApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WebSocketDemoApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void contextLoads() {

	}

	@Test
	public void testSave(){
		User user = new User();
		user.setEmail("120986720@qq.com");
		user.setPswd("123456");
		userMapper.insertSelective(user);
	}

}
