package com.example;

import com.example.controller.HelloController;
import com.example.dao.UserMapper;
import com.example.entity.AppProperty;
import com.example.entity.User;
import com.example.entity.UserInfo;
import com.example.service.UserService;
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

import java.io.*;

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
//	private IUserService userService;
	@Autowired
	private UserMapper userMapper;

	@Autowired
	private UserService userService;


	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
//		userService.deleteAllUsers();
	}

	@Test
	@Rollback
	public void findByName() throws Exception {
		userMapper.clear();
		userMapper.insert("Moon1", "123456");
		userMapper.insert("admin", "admin");
		User u = userMapper.selectByUsername("Moon1");
		Assert.assertEquals("123456", u.getPassword());
		long startTime = System.currentTimeMillis();
//		for(int i = 1; i <= 1000000; i++) {
//			String username = "user_" + i;
//			userMapper.insert(username, username);
//		}
		//for (int i = 0; i < 10000; i++) {
			UserInfo userInfo = userMapper.selectUserInfoByName("user_9000000");
		//}
		long endTime = System.currentTimeMillis();
		System.out.println(userInfo.age + userInfo.salary +userInfo.username);

		System.out.println("执行时间: " + (endTime-startTime) + " ms");
	}

	@Test
	public void findName() throws Exception {
		User user = (User) userService.loadUserByUsername("admin");
		Assert.assertEquals("admin", user.getPassword());
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


	@Test
	public void testWriteFile() throws Exception {
		System.out.println("开始执行： " + System.currentTimeMillis());
		long startTime = System.currentTimeMillis();
		File file = new File("/home/hadoop/table_user.txt");
		if (file.exists()) {
			file.delete();
			file.createNewFile();
		}
		FileOutputStream out = new FileOutputStream(file);
		OutputStreamWriter osw = new OutputStreamWriter(out);
		for(int i = 1; i <= 10000000; i++) {
			String user = "user_" + i;
			int age = i%100;
			String city = "深圳";
			int salary = i;
			String sex = "男";

			osw.write(user +"\t" + user + "\t" + age + "\t" +
						city + "\t" + salary + "\t" + sex + "\t\n");
		}

		osw.close();
		out.close();
		long endTime = System.currentTimeMillis();
		System.out.println("执行时间: " + (endTime - startTime));
	}
}
