package com.example.entity;

/**
 * Created by hadoop on 16-12-11.
 */
public class TestData {
    public static Integer mAutoId = 0;
    public Integer id;
    public String testName;
    public String produceName;
    public String testTime;
    public Integer testResult;

    public TestData() {
        this.id = ++this.mAutoId;
        this.testName = "ID一致性";
        this.produceName = "FS0";
        this.testTime = "2016-11-12 14:20:09";
        this.testResult = 1;
    }
}
