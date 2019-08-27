package com.ym.realm;

import com.ym.pojo.Users;
import com.ym.service.UsersService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

public class userRealm  extends AuthorizingRealm {
    @Resource
    private UsersService usersService;
    @Override
    public String getName() {
        return "userRealm";
    }
    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username=token.getPrincipal().toString();
        Users users=usersService.selUserByUsername(username);
        SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(users,users.getPassword(),getName());
        return info;
    }
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }


}
