package com.xc.service;

import com.xc.pojo.SpuAttrValue;

import java.util.List;

public interface SpuAttrValueService {
    List<SpuAttrValue> findValueById(String key_id);
}
