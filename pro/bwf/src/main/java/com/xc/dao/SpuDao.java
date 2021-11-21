package com.xc.dao;

import com.xc.pojo.Spu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpuDao {


    void insertSpu(Spu spu);

    /**
     * 获取商品列表
     * @return
     */
    List<Spu> getSpuList();

    /**
     *商品分类表插入
     * @param spu_id
     * @param cate_id
     */
    void insertCateId(@Param("spu_id") Long spu_id, @Param("cate_id") Integer cate_id);

    /**
     * 插入商品图片
     * @param spu_id
     * @param value_id
     */
    void insertValueImage(@Param("spu_id") Long spu_id, @Param("value_ids") Integer[] value_id);

    /**
     * 获取商品
     * @param spu_id
     * @return
     */
    Spu findSpuById(@Param("spu_id") Long spu_id);
}
