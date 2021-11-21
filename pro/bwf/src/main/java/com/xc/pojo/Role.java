package com.xc.pojo;

import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.List;

public class Role implements GrantedAuthority {
    private Integer role_id;
    private String role_name;
    private Integer xzrole_id;
    private String xzrole_name;
    private List<Permission> permissionList=new ArrayList<>();

    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }

    public Integer getXzrole_id() {
        return xzrole_id;
    }

    public void setXzrole_id(Integer xzrole_id) {
        this.xzrole_id = xzrole_id;
    }

    public String getXzrole_name() {
        return xzrole_name;
    }

    public void setXzrole_name(String xzrole_name) {
        this.xzrole_name = xzrole_name;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    //获取当前角色名称
    @Override
    public String getAuthority() {
        return this.getRole_name();
    }
}
