package com.xc.pojo;

public class Permission {
    private Integer permission_id;
    private String permission_name;
    private Integer pid;
    private String xzpermission_name;
    private Integer xzpid;
    private Integer xzpermission_id;

    public String getXzpermission_name() {
        return xzpermission_name;
    }

    public void setXzpermission_name(String xzpermission_name) {
        this.xzpermission_name = xzpermission_name;
    }

    public Integer getXzpid() {
        return xzpid;
    }

    public void setXzpid(Integer xzpid) {
        this.xzpid = xzpid;
    }

    public Integer getXzpermission_id() {
        return xzpermission_id;
    }

    public void setXzpermission_id(Integer xzpermission_id) {
        this.xzpermission_id = xzpermission_id;
    }

    public Integer getPermission_id() {
        return permission_id;
    }

    public void setPermission_id(Integer permission_id) {
        this.permission_id = permission_id;
    }

    public String getPermission_name() {
        return permission_name;
    }

    public void setPermission_name(String permission_name) {
        this.permission_name = permission_name;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}
