package com.xc.service.Impl;

import com.xc.dao.CategoryDao;
import com.xc.dao.SpuAttrKeyDao;
import com.xc.pojo.Category;
import com.xc.service.CategoryService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private SpuAttrKeyDao spuAttrKeyDao;

    /**
     * 获取所有的分类
     * @return
     */
    @Override
    public List<Category> findAllCategory() {
        return categoryDao.findAllCategory();
    }

    /**
     * 添加分类
     * @param c
     * @param brand_id
     * @param key_name
     */
    @Override
    public void saveCategory(Category c, Integer brand_id, String[] key_name) {
        //保存分类
        categoryDao.insertCategory(c);
        //保存分类和品牌的关系
        categoryDao.saveCateBrand(c.getCate_id(),brand_id);
        //保存属性键
        for (String kn:key_name) {
            //生成属性键的id
            String key_id=new Date().getTime()+ UUID.randomUUID().toString().replace("-","");
            //插入数据库
            spuAttrKeyDao.insertSpuAttr(key_id,kn);
            //保存分类和属性键直接的关系
            spuAttrKeyDao.insertSpuAttrCate(key_id,c.getCate_id());
        }

    }

    @Override
    public List<Category> findCateById(Integer pid) {
        return categoryDao.findCateById(pid);
    }
}
