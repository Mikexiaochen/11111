package com.xc.dao;

import com.xc.pojo.SpuAttrValue;
import com.xc.pojo.SpuAttrValueSpus;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpuAttrValueDao {
    List<SpuAttrValue> getSpuAttrValueListByKeyId(@Param("key_id") String key_id);

    void deleteSpuKeyValue(@Param("value_attr_key_id") String key_id);

    void insertSpuValue(@Param("value_attr_key_id") String key_id, @Param("value_names") String[] value_name);

    List<SpuAttrValue> findValueById(@Param("value_attr_key_id") String key_id);

    SpuAttrValueSpus findspuAttrValueSpusListBySpuId(@Param("spu_id") Long spu_id);
}
