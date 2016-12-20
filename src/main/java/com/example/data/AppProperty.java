package com.example.data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by hadoop on 16-12-2.
 */
@Configuration
public class AppProperty {
    @Value("${com.example.demo.name}")
    private String name;
    @Value("${com.example.demo.vercode}")
    private String verCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVerCode() {
        return verCode;
    }

    public void setVerCode(String verCode) {
        this.verCode = verCode;
    }
}
