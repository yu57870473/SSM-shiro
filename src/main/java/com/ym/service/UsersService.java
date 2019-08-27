package com.ym.service;

import com.ym.pojo.Users;

import java.util.List;

public interface UsersService {
    int insUsers(Users users);
    Users selUserByUsername(String username);
}
