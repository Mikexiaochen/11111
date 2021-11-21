package com.xc.service;

import com.xc.pojo.Permission;

import java.util.List;

public interface PermissionService {
    /**
     * 获取所有的权限列表
     * @return
     */
    List<Permission> findAllPermission();
}
