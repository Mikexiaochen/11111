package com.xc.dao;

import com.xc.pojo.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionDao {
    /**
     * 查询所有的权限
     * @return
     */
    List<Permission> findAllPermission();

    List<Permission> getPermissionListByRoleId(@Param("role_id") Integer role_id);
}
