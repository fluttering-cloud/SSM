package com.wang.config;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class UserRealm extends AuthorizingRealm {

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        System.out.println("==>执行了doGetAuthorizationInfo方法");
        return null;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //伪造数据
        String name = "root";
        String password = "123456";

        System.out.println("==>执行了doGetAuthenticationInfo方法");


        //System.out.println("debug==>用户名："+authenticationToken.getUsername());
        System.out.println("debug==>Principal"+authenticationToken.getPrincipal());
        System.out.println("debug==>Credentials"+authenticationToken.getCredentials());
        if(!authenticationToken.getPrincipal().equals(name)){
            return null;
        }
        return new SimpleAuthenticationInfo(authenticationToken.getPrincipal(),password,"");
    }
}
