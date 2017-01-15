package com.example.dao;

import com.example.entity.User;
import com.example.entity.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

/**
 * Created by hadoop on 16-12-2.
 * UserMapper mybatis的Mapper配置
 */
@Service
@Mapper
public interface UserMapper {

//    User selectById(String id);
//    User selectByUsername(String username);

    @Select("SELECT * FROM User WHERE id = #{id}")
    User selectById(@Param("id") Integer id);

    @Select("SELECT * FROM User WHERE username = #{username}")
    User selectByUsername(@Param("username") String username);

    @Insert("INSERT INTO User(username, password, role) VALUES(#{username}, #{password}, #{role})")
    int insertUser(@Param("username") String username,
               @Param("password") String password,
               @Param("role") String role);

    @Insert("INSERT INTO User(username, password, role) VALUES(#{username}, #{password}, 'ROLE_user')")
    int insert(@Param("username") String username,
               @Param("password") String password);

    @Delete("DELETE FROM User")
    void clear();


    @Select("SELECT * FROM UserInfo WHERE username = #{username}")
    UserInfo selectUserInfoByName(@Param("username") String username);
}

