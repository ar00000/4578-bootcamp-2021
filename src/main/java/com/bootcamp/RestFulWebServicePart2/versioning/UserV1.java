package com.bootcamp.RestFulWebServicePart2.versioning;

public class UserV1 {
    private String name;
    private Integer age;

    public UserV1() {
    }

    public UserV1(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
