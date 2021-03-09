package com.bootcamp.RestFulWebServicePart2.user;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;

import java.util.Iterator;
import java.util.List;

@Component
public class UserService {
    public static List<User> users = new ArrayList<>();
    public static int countUsers = 3;

    static {
        users.add(new User(1,"John",new Date()));
        users.add(new User(2,"Rose",new Date()));
        users.add(new User(3,"Mary",new Date()));
    }

    public List<User> findAll(){
        return users;
    }

    public User addUser(User user){
        if(user.getId()==null){
            user.setId(++countUsers);
        }
        users.add(user);
        return user;
    }

    public User deleteUser(int id){
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()){
            User user = iterator.next();
            if(user.getId()==id){
                iterator.remove();
                return user;
            }
        }
        return null;
    }
}

