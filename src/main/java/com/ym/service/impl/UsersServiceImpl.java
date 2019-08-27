package com.ym.service.impl;

import com.ym.mapper.UsersMapper;
import com.ym.pojo.Users;
import com.ym.service.UsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UsersServiceImpl implements UsersService {
    @Resource
    private UsersMapper usersMapper;
    @Override
    public int insUsers(Users users) {
        return usersMapper.insUsers(users);
    }

    @Override
    public Users selUserByUsername(String username) {
        if(username==null){
            //抛异常
        }
        return usersMapper.selUserByUsername(username);
    }
}
