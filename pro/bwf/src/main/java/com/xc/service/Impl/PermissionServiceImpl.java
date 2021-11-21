package com.xc.service.Impl;

import com.xc.dao.PermissionDao;
import com.xc.pojo.Permission;
import com.xc.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionDao permissionDao;
    @Override
    public List<Permission> findAllPermission() {
        return permissionDao.findAllPermission();
    }
}
