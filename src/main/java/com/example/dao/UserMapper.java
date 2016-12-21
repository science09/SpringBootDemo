package com.example.dao;

import com.example.data.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

/**
 * Created by hadoop on 16-12-2.
 */
@Mapper
@Component
public interface UserMapper {

    @Select("SELECT * FROM User WHERE id = #{id}")
    User findtById(@Param("id") Integer id);

    @Select("SELECT * FROM User WHERE username = #{username}")
    User findByUsername(@Param("username") String username);

    @Insert("INSERT INTO User(username, password, role) VALUES(#{username}, #{password}, #{role})")
    int insertUser(@Param("username") String username,
               @Param("password") String password,
               @Param("role") String role);

    @Insert("INSERT INTO User(username, password, role) VALUES(#{username}, #{password}, 'ROLE_user')")
    int insert(@Param("username") String username,
               @Param("password") String password);

    @Delete("DELETE FROM User")
    void clear();

}

