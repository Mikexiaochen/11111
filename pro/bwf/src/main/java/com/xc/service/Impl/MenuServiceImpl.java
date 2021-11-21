package com.xc.service.Impl;

import com.xc.dao.MenuDao;
import com.xc.pojo.Menu;
import com.xc.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MenuServiceImpl implements MenuService{

    @Autowired
    private MenuDao md;
    @Override
    public List<Menu> findMenuListByAdminName(String adminname) {
        return md.findMenuListByAdminName(adminname);
    }
}
