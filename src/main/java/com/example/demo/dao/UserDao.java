package com.example.demo.dao;

import com.example.demo.model.User;
import com.example.demo.model.Users;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Component("userDao")
public interface UserDao {
    //MyBatis的注解
    @Select("select id, company from suppliers")
    public List<User> getUserList();

    @Delete("delete from suppliers where id=#{id}")
    public boolean deleteUser(int id);

    @Update("update suppliers set company=#{company} where id=#{id}")
    public boolean updateUser(@Param("id") int id,@Param("company") String company);

    @Insert("insert into suppliers(id,company) values (#{id},#{company})")
    public boolean insertUser(@Param("id") int id,@Param("company") String company);

    @Select("select username, password from users where username=#{username} and password=#{password}")
    public List<Users> getUsersIdList(@Param("username") String username, @Param("password") String password);

    @Insert("insert into users(username,password) values (#{username},#{password})")
    public boolean insertUsers(@Param("username") String username, @Param("password") String password);
}
