package com.bootcamp.RestFulWebServicePart2.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(description = "All Details about users: Id, Name & Birthdate")
public class User {
    @ApiModelProperty(notes = "Users unique id")
    private Integer id;
    @ApiModelProperty(notes = "Should be string")
    private String name;
    @ApiModelProperty(notes = "Should be date")
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
