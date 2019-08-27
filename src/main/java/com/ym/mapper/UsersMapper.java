package com.ym.mapper;

import com.ym.pojo.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UsersMapper {
    @Insert("insert into users values(default,#{username},#{password},#{photoname})")
    int insUsers(Users users);
    @Select("select * from users where username=#{username}")
    Users selUserByUsername(String username);
}
