package com.xc.dao;

import com.xc.pojo.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminDao {
    /**
     * 根据用户名获取员工对象
     * @param s 用户名
     * @return 用户对象
     */
    Admin getAdminByName(@Param("admin_name") String s);

    /**
     * 获取所有员工
     * @return
     */
    List<Admin> findAllAdmin();

    /**
     *
     *添加员工
     * @param admin
     */
    void insertAdmin(@Param("admin") Admin admin);

    /**
     * 添加员工指定的角色
     * @param admin_id
     * @param role_id
     */
    void insertRole(@Param("admin_id") Integer admin_id,@Param("role_ids") Integer[] role_id);

    /**
     * 修改员工
     * @param admin_id
     * @return
     */
    Admin findAdminById(Integer admin_id);

    /**
     * 更新用户
     * @param admin
     */
    void updateAdmin(Admin admin);

    /**
     * 删除用户所有的角色
     * @param admin_id
     */
    void deleteAdminRole(Integer admin_id);

    /**
     * 删除员工
     * @param admin_id
     */
    void deleteAdmin(Integer admin_id);

    /**
     * 查询员工
     * @param admin
     * @return
     */
    List<Admin> findAdmin(Admin admin);
}
