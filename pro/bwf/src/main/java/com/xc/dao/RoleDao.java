package com.xc.dao;

import com.xc.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleDao {

    /**
     * 根据用户的id查询角色列表
     * @param admin_id
     * @return
     */
    List<Role> getRoleListByAdminId(@Param("admin_id") Integer admin_id);

    /**
     * 根据访问的url地址查询角色列表
     * @param requrl
     * @return
     */
    List<Role> getRoleListByOperateUrl(@Param("operate_url") String requrl);

    /**
     * 查询角色列表
     * @return
     */
    List<Role> findAllRole();

    /**
     *根据用户id查询角色列表
     * @param admin_id
     * @return
     */
    List<Role> getRoleListByAdminIdAll(@Param("admin_id") Integer admin_id);

    /**
     * 插入角色
     * @param role
     */
    void insertRole(Role role);

    /**
     * 插入角色指定权限
     * @param role_id
     * @param permission_id
     */
    void insertRolePerssion(@Param("role_id") Integer role_id,@Param("permission_ids") Integer[] permission_id);

    /**
     *
     *根据用户角色id查询用户角色
     * @param role_id
     * @return
     */
    Role findRoleById(Integer role_id);

    /**
     * 更新角色
     * @param role
     */
    void updateRole(Role role);

    /**
     * 删除原有权限
     * @param role_id
     */
    void deleteRolePermission(@Param("role_id") Integer role_id);

    /**
     * 删除角色
     * @param role_id
     */
    void deleteRole(Integer role_id);

    /**
     * 删除角色相关
     * @param role_id
     */
    void deleteAdmin(Integer role_id);
}
