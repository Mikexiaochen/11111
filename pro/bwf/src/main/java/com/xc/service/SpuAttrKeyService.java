package com.xc.service;

import com.xc.pojo.SpuAttrKey;

import java.util.List;

public interface SpuAttrKeyService {

    /**
     * 修改属性键属性值
     * @param spuAttrKey
     * @param value_name
     */
    void updataSpuKey(SpuAttrKey spuAttrKey, String[] value_name);

    /**
     * 获取属性键列表
     * @return
     */
    List<SpuAttrKey> findAllSpuAttrKey();



    /**
     * 根据id获取属性键对象也可以获取指定值列表
     * @return
     */
    SpuAttrKey findSpuAttrKey(String key_id);

    /**
     * 根据cate_id获取属性键列表
     * @param cate_id
     * @return
     */
    List<SpuAttrKey> findSpuAttrKeyById(Integer cate_id);
}
