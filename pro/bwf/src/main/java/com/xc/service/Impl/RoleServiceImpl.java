package com.xc.service.Impl;

import com.xc.dao.RoleDao;
import com.xc.pojo.Role;
import com.xc.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao rd;
    @Override
    public List<Role> findAllRole() {
        return rd.findAllRole();
    }

    @Override
    public void saveRole(Role role, Integer[] permission_id) {
        //插入角色
        rd.insertRole(role);
        //插入指定权限
        rd.insertRolePerssion(role.getRole_id(),permission_id);
    }

    @Override
    public Role findRoleById(Integer role_id) {
        return rd.findRoleById(role_id);
    }

    @Override
    public void updateRole(Role role, Integer[] permission_id) {
        rd.updateRole(role);
        //更新权限，删除原有权限，添加新权限
        rd.deleteRolePermission(role.getRole_id());

        rd.insertRolePerssion(role.getRole_id(),permission_id);
    }

    @Override
    public void deleteRole(Integer role_id) {
        //删除角色，先删除角色相关，删除权限，在删除角色
        rd.deleteAdmin(role_id);

        rd.deleteRolePermission(role_id);

        rd.deleteRole(role_id);
    }

}
