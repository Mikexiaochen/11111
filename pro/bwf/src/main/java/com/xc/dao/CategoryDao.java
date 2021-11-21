package com.xc.dao;

import com.xc.pojo.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryDao {

    List<Category> findAllCategory();

    /**
     * 插入分类
     * @param c
     */
    void insertCategory(Category c);

    /**
     * 创建分类和品牌的关系
     * @param cate_id
     * @param brand_id
     */
    void saveCateBrand(@Param("category_id") Integer cate_id, @Param("brand_id") Integer brand_id);

    /**
     * 根据父类id获取子类
     * @param pid
     * @return
     */
    List<Category> findCateById(@Param("cate_parentid") Integer pid);
}
