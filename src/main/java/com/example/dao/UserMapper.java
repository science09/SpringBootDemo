package com.example.dao;

import com.example.data.User;
import org.apache.ibatis.annotations.*;

/**
 * Created by hadoop on 16-12-2.
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM USER WHERE NAME = #{name}")
    User findByName(@Param("name") String name);

    @Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);

    @Delete("DELETE FROM USER")
    void clear();

}

