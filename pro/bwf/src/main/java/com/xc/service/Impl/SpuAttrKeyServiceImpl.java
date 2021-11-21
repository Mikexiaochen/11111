package com.xc.service.Impl;

import com.xc.common.Common;
import com.xc.dao.SpuAttrKeyDao;
import com.xc.dao.SpuAttrValueDao;
import com.xc.pojo.SpuAttrKey;
import com.xc.service.SpuAttrKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpuAttrKeyServiceImpl implements SpuAttrKeyService {

    @Autowired
    private SpuAttrKeyDao spuAttrKeyDao;
    @Autowired
    private SpuAttrValueDao spuAttrValueDao;
    @Override
    public void updataSpuKey(SpuAttrKey spuAttrKey, String[] value_name) {
        //根据属性键更新
        spuAttrKeyDao.saveSpukey(spuAttrKey);
        //更新属性值根据属性键id
        //删除原有属性值
        spuAttrValueDao.deleteSpuKeyValue(spuAttrKey.getKey_id());
        //添加属性值
        spuAttrValueDao.insertSpuValue(spuAttrKey.getKey_id(),value_name);
    }

    @Override
    public List<SpuAttrKey> findAllSpuAttrKey() {
        return spuAttrKeyDao.findShaiXuanAttr(Common.SHAI_XUAN_ATTR);
    }

    @Override
    public SpuAttrKey findSpuAttrKey(String key_id) {
        SpuAttrKey spuAttrKey=spuAttrKeyDao.findSpuAttrkeyById(key_id);
        return spuAttrKey;
    }

    @Override
    public List<SpuAttrKey> findSpuAttrKeyById(Integer cate_id) {
        return spuAttrKeyDao.findSpuAttrKeyByCateId(cate_id);
    }
}
