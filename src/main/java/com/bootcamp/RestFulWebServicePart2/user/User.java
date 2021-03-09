package com.bootcamp.RestFulWebServicePart2.user;

import com.fasterxml.jackson.annotation.JsonFilter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(description = "All Details about users: Id, Name & Birthdate")
@JsonFilter("passwordFilter")
public class User {
    @ApiModelProperty(notes = "Users unique id")
    private Integer id;
    @ApiModelProperty(notes = "Should be string")
    private String name;
    @ApiModelProperty(notes = "Should be date")
    private Date birthDate;
    //@JsonIgnore
    @ApiModelProperty(notes = "Password should not be visible in response")
    private String password;

    protected User(){
    }

    public User(Integer id, String name, Date birthDate, String password) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
