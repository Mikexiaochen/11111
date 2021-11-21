package com.xc.service.Impl;

import com.xc.dao.AdminDao;
import com.xc.pojo.Admin;
import com.xc.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional//添加事务
public class AdminServiceImpl implements IAdminService {
    @Autowired
    private AdminDao ad;
    @Override
    public List<Admin> findAllAdmin() {

        return ad.findAllAdmin();
    }

    @Override
    public void saveAdmin(Admin admin, Integer[] role_id) {
        //判断是否已经存在
        Admin a=ad.getAdminByName(admin.getAdmin_name());
        // 如果不存在添加到员工页面，根据添加员工的id插入员工角色
        if(a==null){
            //添加员工
            ad.insertAdmin(admin);
            //添加员工角色
            if(role_id!=null){
                ad.insertRole(admin.getAdmin_id(),role_id);
            }

        }
        //
    }

    @Override
    public Admin findAdminById(Integer admin_id) {
        return ad.findAdminById(admin_id);
    }

    @Override
    public void updateAdmin(Admin admin, Integer[] role_id) {
        //更新admin表
        ad.updateAdmin(admin);
        //删除当前用户所有角色
        ad.deleteAdminRole(admin.getAdmin_id());
        //添加角色
        ad.insertRole(admin.getAdmin_id(),role_id);

    }

    @Override
    public void deleteAdmin(Integer admin_id) {
        //删除员工分配的角色
        ad.deleteAdminRole(admin_id);
        //删除员工
        ad.deleteAdmin(admin_id);

    }

    @Override
    public List<Admin> findAllAdmin(Admin admin) {
        return ad.findAdmin(admin);
    }
}
