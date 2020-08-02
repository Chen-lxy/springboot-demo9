package com.chen.study.mapper;

import com.chen.study.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Select("select * from user where id=#{id}")
    User queryById(@Param("id") int id);

    @Select("select * from user")
    List<User> queryAll();

    @Insert("insert into user(username,password) values(#{username},#{password})")
    int addUser(User user);

    @Delete("delete from user where id = #{id}")
    int deleteById(int id);

    @Update("update user set username=#{username},password=#{password} where id=#{id}")
    int updateUser(User user);
}
