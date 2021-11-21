package com.xc.service.Impl;

import com.xc.dao.SpuAttrKeyDao;
import com.xc.dao.SpuAttrValueDao;
import com.xc.dao.SpuDao;
import com.xc.pojo.Spu;
import com.xc.pojo.SpuAttrKey;
import com.xc.pojo.SpuAttrValue;
import com.xc.pojo.Vo;
import com.xc.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class SpuServiceImpl implements SpuService {
    @Autowired
    private SpuDao spuDao;

    @Autowired
    private SpuAttrValueDao spuAttrValueDao;
    @Autowired
    private SpuAttrKeyDao spuAttrKeyDao;
    @Override
    public List<Spu> getSpuList() {
        return spuDao.getSpuList();
    }

    @Override
    public void saveSpu(Spu spu, String spu_brand_id, Integer cate_id, Integer[] value_id, Vo vo) {
        //插入spu
        spuDao.insertSpu(spu);
        //插入spu分类表
        spuDao.insertCateId(spu.getSpu_id(),cate_id);
        //插入属性值对应的相册
        spuDao.insertValueImage(spu.getSpu_id(),value_id);
        //插入书写的属性键属性值
        //生成属性键的id
        String key_id=new Date().getTime()+ UUID.randomUUID().toString().replace("-","");
        //插入数据库 key
        spuAttrKeyDao.insertSpuAttr(key_id,vo.getList().get(0).getKeyn());
        //保存属性键和分类直接的关系
        spuAttrKeyDao.insertSpuAttrCate(key_id, cate_id);
        //插入值列表 value
        spuAttrValueDao.insertSpuValue(key_id,vo.getList().get(0).getValuen());
        //插入属性键和分类表
    }

    @Override
    public Spu getSpuById(Long spu_id) {
        return spuDao.findSpuById(spu_id);
    }
}
