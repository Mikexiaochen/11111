package com.xc.service;

import com.xc.pojo.Menu;

import java.util.List;

public interface MenuService {

    List<Menu> findMenuListByAdminName(String adminname);
}
