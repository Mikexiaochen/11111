package com.xc.service;

import com.xc.pojo.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAllCategory();

    /**
     * 添加分类
     * @param c
     * @param brand_id
     * @param key_name
     */
    void saveCategory(Category c, Integer brand_id, String[] key_name);

    /**
     * 获取分类
     * @param pid
     * @return
     */
    List<Category> findCateById(Integer pid);
}
