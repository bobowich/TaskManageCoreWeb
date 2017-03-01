package com.rosin.manager.mobile.shiro;


import com.rosin.manager.common.dao.UserMapper;
import com.rosin.manager.common.model.Permission;
import com.rosin.manager.common.model.Role;
import com.rosin.manager.common.model.User;
import com.rosin.manager.mobile.serviceImpl.UserServiceImpl;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2017/2/25.
 */
public class MyRealm extends AuthorizingRealm {

    private static Logger logger = Logger.getLogger(MyRealm.class);


    @Autowired
    UserServiceImpl userServiceImpl;




    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = principalCollection.getPrimaryPrincipal().toString();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        User user = userServiceImpl.findUserByUsername(username);
        logger.info("MyRealm"+"--"+"doGetAuthorizationInfo"+"--");
        if (user != null) {
            //添加对应的角色
            Role role = user.getRole();
            if (role != null) {
                info.addRole(role.getRoleName());
                logger.info("MyRealm"+"--"+"doGetAuthorizationInfo"+"--"+role.getRoleName());
                List<Permission> permissions = role.getPermissions();
                if (permissions != null && permissions.size() > 0) {
                    //添加对应的权限
                    for (Permission p : permissions) {
                        info.addStringPermission(p.getPermName());
                    }
                }
            }
            return info;
        }
        return null;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = authenticationToken.getPrincipal().toString();
        User user = userServiceImpl.findUserByUsername(username);
        if (user != null) {
            logger.info("MyRealm"+"--"+"doGetAuthenticationInfo"+"--");
            //将查询到的用户账号和密码存放到 authenticationInfo用于后面的权限判断。第三个参数随便放一个就行,这里放入真实姓名
            AuthenticationInfo info = new SimpleAuthenticationInfo(user.getUserName(), user.getUserPassword(), user.getRealName());
            return info;
        } else {
            return null;
        }
    }
}
