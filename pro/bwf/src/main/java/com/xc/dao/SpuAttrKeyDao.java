package com.xc.dao;

import com.xc.pojo.SpuAttrKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpuAttrKeyDao {
    /**
     * 属性键的插入
     * @param key_id 属性键的id
     * @param kn 属性键的名字
     */
    void insertSpuAttr(@Param("key_id") String key_id, @Param("key_name") String kn);

    /**
     * 创建属性和分类的关系
     * @param key_id
     * @param cate_id
     */
    void insertSpuAttrCate(@Param("key_id") String key_id, @Param("cate_id") Integer cate_id);

    /**
     * 获取所有的筛选属性
     * @param shaiXuanAttr
     * @return
     */
    List<SpuAttrKey> findShaiXuanAttr(@Param("key_issku") Integer shaiXuanAttr);

    /**
     * 根据id获取当前的属性键对象
     * @param key_id
     * @return
     */
    SpuAttrKey findSpuAttrkeyById(String key_id);

    /**
     * 更新属性键
     * @param spuAttrKey
     */
    void saveSpukey(SpuAttrKey spuAttrKey);

    /**
     * 获取属性键
     * @param cate_id
     * @return
     */
    List<SpuAttrKey> findSpuAttrKeyByCateId(@Param("category_id") Integer cate_id);

    List<SpuAttrKey> findSpuAttrKeyBySpuId(@Param("spu_id") Long spu_id);
}
