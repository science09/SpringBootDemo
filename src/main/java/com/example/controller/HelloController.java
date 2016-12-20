package com.example.controller;

import com.example.data.AppProperty;
import com.example.data.Result;
import com.example.data.TestData;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/data_table.html")
    public String index(ModelMap map) {
        logger.info("Request data_table.html Page!");
        logger.info("AppName:" + app.getName());
        map.addAttribute("host",  "This is from thymeleaf");
        return "data_table";
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
        return "<h1> data_table.html <h1>";
    }
}
