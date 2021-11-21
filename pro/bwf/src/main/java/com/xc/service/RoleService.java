package com.xc.service;

import com.xc.pojo.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAllRole();


    void saveRole(Role role, Integer[] permission_id);

    /**
     * 获取角色对象
     * @param role_id
     * @return
     */
    Role findRoleById(Integer role_id);

    /**
     * 更新角色以及重新给角色分配权限
     * @param role
     * @param permission_id
     */
    void updateRole(Role role, Integer[] permission_id);

    /**
     * 删除角色
     * @param role_id
     */
    void deleteRole(Integer role_id);
}
