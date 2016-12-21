package com.example.controller;

import com.example.data.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by hadoop on 16-12-1.
 * UserController
 */
@RestController
@RequestMapping(value="/users")
public class UserController {
    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<>());

    static {
        User mUser1 = new User(1, "Lily", "12345");
        User mUser2 = new User(2, "Kevin", "23456");
        users.put(1L, mUser1);
        users.put(2L, mUser2);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getUserList() {
        List<User> mList = new ArrayList<User>(users.values());
        return mList;
    }

    @RequestMapping(value="/", method=RequestMethod.POST)
    public String postUser(@ModelAttribute User user) {
        // 处理"/users/"的POST请求，用来创建User
        // 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数
        users.put(user.getId().longValue(), user);
        return "success";
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        // 处理"/users/{id}"的GET请求，用来获取url中id值的User信息
        // url中的id可通过@PathVariable绑定到函数的参数中
        return users.get(id);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public String putUser(@PathVariable Long id, @ModelAttribute User user) {
        // 处理"/users/{id}"的PUT请求，用来更新User信息
        User u = users.get(id);
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        users.put(id, u);
        return "success";
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        // 处理"/users/{id}"的DELETE请求，用来删除User
        users.remove(id);
        return "success";
    }
}
