package com.xc.security;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
@Component
public class RenZheng implements AccessDecisionManager {
    /**
     *
     * @param authentication 封装了当前登录的用户的角色列表
     * @param o
     * @param collection 当前url拥有的访问的角色列表，已经被授权的角色列表，就是刚才shouquan类中返回的那个角色列表
     * @throws AccessDeniedException
     * @throws InsufficientAuthenticationException
     */
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
        //如果没有做任何操作，就是所有的url都是放行的
        System.out.println("****开始认证****");

        //循环url指定的角色列表
        for (ConfigAttribute attr:collection) {
            //判断当前登录的用户对象是否为空
            if(authentication==null){
                System.out.println("****权限认证失败");
                throw new AccessDeniedException("权限认证失败");
            }
            //通过attr对象获取这个对象指定的角色名称
            String mingcheng=attr.getAttribute();
            if("ROLE_LOGIN".equals(mingcheng)){
                if(authentication instanceof AnonymousAuthenticationToken){
                    System.out.println("*****用户没有进行登录");
                    throw new BadCredentialsException("用户还没有进行登录");
                }else{
                    //已经登录，就直接放行，一般访问公告的页面
                    return;
                }
            }
            Collection<? extends GrantedAuthority> roleList=authentication.getAuthorities();
            for(GrantedAuthority role:roleList){
                System.out.println("当前的身份是："+role.getAuthority());
                if(mingcheng.equals(role.getAuthority())){
                    System.out.println("**认证成功");
                    return;
                }
            }
        }
        System.out.println("认证结束");
        //针对url没有访问权限
        throw new AccessDeniedException("权限认证失败");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return false;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
