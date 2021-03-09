package com.bootcamp.RestFulWebServicePart2.user;

import java.util.Date;

public class User {
    private Integer id;
    private String name;
    private Date birtDate;

    protected User(){

    }
    public User(Integer id, String name, Date birtDate) {
        this.id = id;
        this.name = name;
        this.birtDate = birtDate;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getBirtDate() {
        return birtDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirtDate(Date birtDate) {
        this.birtDate = birtDate;
    }
}
