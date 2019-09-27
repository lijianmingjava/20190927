package com.lanxin.shiro;


import com.lanxin.dao.UserDao;
import com.lanxin.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;


public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override//授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        Object obj = String.valueOf(principalCollection.getPrimaryPrincipal());

        if (obj instanceof String) {

            String username = String.valueOf(obj);

            authorizationInfo.addRoles(userService.getRolesByUserName(username));

            authorizationInfo.addStringPermissions(userService.getPermissionsByUserName(username));

        }

        return authorizationInfo;
    }

    @Override//认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        String username = (String) authenticationToken.getPrincipal();

        String password = userService.getPassWordByUserName(username);

        if (password != null) {

            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username, password, getName());

            simpleAuthenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(username));

            return simpleAuthenticationInfo;

        }

        return null;

    }
}
