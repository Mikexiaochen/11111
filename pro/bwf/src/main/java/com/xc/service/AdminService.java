package com.xc.service;

import com.xc.dao.AdminDao;
import com.xc.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService implements UserDetailsService {

    @Autowired
    private AdminDao adminDao;
    //根据用户名返回用户对象
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //根据用户名去数据库进行查询
        Admin  admin=adminDao.getAdminByName(s);
        //如果admin对象为空，登录失败
        if(admin==null){
            throw new UsernameNotFoundException("用户名填写错误");
        }
        return admin;
    }


}
