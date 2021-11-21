package com.xc.service;

import com.xc.pojo.Admin;

import java.util.List;

public interface IAdminService {
    /*员工管理获取员工信息*/
    List<Admin> findAllAdmin();
    /*添加员工*/
    void saveAdmin(Admin admin, Integer[] role_id);
    /*修改员工*/
    Admin findAdminById(Integer admin_id);
    /*更新用户*/
    void updateAdmin(Admin admin, Integer[] role_id);
    /*删除员工*/
    void deleteAdmin(Integer admin_id);
    /*查询员工*/
    List<Admin> findAllAdmin(Admin admin);
}
