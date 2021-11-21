package com.xc.controller;

import com.xc.pojo.Permission;
import com.xc.pojo.Role;
import com.xc.service.PermissionService;
import com.xc.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;
    /*显示角色列表*/
    @RequestMapping("/admin")
    public void admin(Model model){
        List<Role> roleList=roleService.findAllRole();
        model.addAttribute("roleList",roleList);
    }
    /*进入添加角色页面*/
    @RequestMapping("/add")
    public void add(Model model){
        //显示所有的权限
        List<Permission> permissionList=permissionService.findAllPermission();
        model.addAttribute("permissionList",permissionList);
    }
    /*添加角色执行*/
    @RequestMapping("/save")
    public String save(Role role,Integer [] permission_id){
        //插入角色到角色表
        //插入角色当前指定权限
        roleService.saveRole(role,permission_id);
        /*System.out.println("添加的角色名是："+role.getRole_name());*/
        return "/common/success";
    }
    /*修改角色执行*/
    @RequestMapping("/update")
    public void update(Integer role_id,Model model){
        Role role =roleService.findRoleById(role_id);
        model.addAttribute("role",role);
    }
    /*修改角色t提交*/
    @RequestMapping("/alter")
    public String alter(Role role,Integer [] permission_id){
        /*System.out.println("id是"+role.getRole_id());
        System.out.println("角色名"+role.getRole_name());
        System.out.println("权限列表"+Arrays.toString(permission_id));*/

        roleService.updateRole(role,permission_id);

        return "/common/success";
    }
    @RequestMapping("/delete")
    public String delete(Integer role_id){
        roleService.deleteRole(role_id);
        return "/common/success";
    }
}
