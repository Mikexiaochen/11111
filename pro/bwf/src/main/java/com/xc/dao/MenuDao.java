package com.xc.dao;

import com.xc.pojo.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 根据用户名称获取菜单列表
 */
public interface MenuDao {
    List<Menu> findMenuListByAdminName(@Param("admin_name")String adminname);
}
