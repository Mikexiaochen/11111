package com.xc.security;

import com.xc.dao.RoleDao;
import com.xc.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
/*授权*/
@Component
public class ShouQuan implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private RoleDao roleDao;
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        //获取访问的url
        FilterInvocation rep=(FilterInvocation) o;
        String requrl=rep.getRequestUrl();
        //根据url获取角色列表，调用dao层
        List<Role> roleList=roleDao.getRoleListByOperateUrl(requrl);
        System.out.println("访问路径"+requrl);

        //当前查询到的角色列表不为空
        if(!roleList.isEmpty() && roleList.size()>0){
            System.out.println("开始授权");
            //定义数组转换放回值类型
            String[] shouquanArr=new String[roleList.size()];
            for (int i=0;i<roleList.size();i++){
                shouquanArr[i]=roleList.get(i).getRole_name();
                System.out.println("授权的角色有:"+roleList.get(i).getRole_name());
            }
            System.out.println("授权完毕");
            return SecurityConfig.createList(shouquanArr);
        }else{
            //如果查询不到角色列表，我们给一个默认角色
            System.out.println("给默认角色的认证");
            return SecurityConfig.createList("ROLE_LOGIN");
        }
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
