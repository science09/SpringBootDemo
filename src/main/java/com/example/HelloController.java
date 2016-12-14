package com.example;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by hadoop on 16-11-30.
 * HelloController
 */
@Controller
public class HelloController {

    private Logger logger = Logger.getLogger(HelloController.class);
    @Autowired
    AppProperty app;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
//        throw new Exception("发生错误");
        System.out.println(app.getName());

//        try {
//            UserServiceImpl userService = new UserServiceImpl();
//            userService.create("Martin", 11);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        return "Hello Spring!";
    }

    @RequestMapping("/")
    public String index(ModelMap map) {
        logger.info("Request Index Page!");
        logger.info("AppName:" + app.getName());
        map.addAttribute("host",  "This is from thymeleaf");
        return "index";
    }

    @RequestMapping("/get_json_data")
    @ResponseBody
    public Result getData() {
        Result result = new Result();

        for(int i = 0; i < 30; i++) {
            TestData testData = new TestData();
            result.data.add(testData);
        }

        return result;
    }

    @RequestMapping("/index.html")
    public String hi() {
        logger.info("Test logger");
        return "<h1> index.html <h1>";
    }
}
