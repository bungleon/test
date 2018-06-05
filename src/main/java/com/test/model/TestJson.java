package com.test.model;

public class TestJson {
    String name;
    TestJson testJson;

    public TestJson(String name, TestJson testJson) {
        this.name = name;
        this.testJson = testJson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TestJson getTestJson() {
        return testJson;
    }

    public void setTestJson(TestJson testJson) {
        this.testJson = testJson;
    }

    @Override
    public String toString() {
        return "TestJson{" +
                "name='" + name + '\'' +
                ", testJson=" + testJson +
                '}';
    }
}
