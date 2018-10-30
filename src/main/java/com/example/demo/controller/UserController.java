package com.example.demo.controller;

import com.example.demo.dao.UserDao;
import com.example.demo.model.User;
import com.example.demo.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getHello(){
        return "Hello word!!!";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public String getIndex(){
        return "index";
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public String getMain(String username, String password){
        List<Users> usersIdList = userDao.getUsersIdList(username, password);
        System.out.println("usersIdList.size()："+usersIdList.size());
        System.out.println("username:"+username+" password:"+password);
        if(usersIdList.size() > 0){
            return "main";
        }
        return "index";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public List<User> getUser(){
        return userDao.getUserList();
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public boolean deteleUser(String id){
        return userDao.deleteUser(Integer.parseInt(id));
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public boolean updateUser(String id, String company){
        return userDao.updateUser(Integer.parseInt(id),company);
    }

    @RequestMapping(value = "/insertUser", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public boolean insertUser(String id, String company){
        return userDao.insertUser(Integer.parseInt(id),company);
    }

    @RequestMapping(value = "/insertUsers", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public String insertUsers(String username, String password){
        if(userDao.insertUsers(username,password) == true){
            return "index";
        }
        return "registered";
    }

    @RequestMapping(value = "/registered", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public String registered(){
        return "registered";
    }

}
