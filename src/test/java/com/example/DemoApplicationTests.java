package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

//	@Test
//	public void contextLoads() {
//	}

	private MockMvc mvc;
	@Autowired
	private AppProperty appProperty;
//	@Autowired
//	private UserService userService;
	@Autowired
	private UserMapper userMapper;


	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
//		userService.deleteAllUsers();
	}

	@Test
	@Rollback
	public void findByName() throws Exception {
		userMapper.clear();
		userMapper.insert("Moon", 12);
		User u = userMapper.findByName("Moon");
		Assert.assertEquals(12, u.getAge().intValue());
	}

//	public void test() throws Exception {
//		// 插入5个用户
//		userService.create("a", 1);
//		userService.create("b", 2);
//		userService.create("c", 3);
//		userService.create("d", 4);
//		userService.create("e", 5);
//		// 查数据库，应该有5个用户
//		Assert.assertEquals(5, userService.getAllUsers().intValue());
//		// 删除两个用户
//		userService.deleteByName("a");
//		userService.deleteByName("e");
//		// 查数据库，应该有5个用户
//		Assert.assertEquals(3, userService.getAllUsers().intValue());
//
//	}

	@Test
	public void getHello() throws Exception {
//		mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
//				.andExpect(status().isOk())
//				.andExpect(content().string(equalTo("Hello Spring!")));
	}

	@Test
	public void testAppName() throws Exception {
		Assert.assertEquals("SpringBoot Demo", appProperty.getName());
		Assert.assertEquals("0.0.1", appProperty.getVerCode());
	}

}
