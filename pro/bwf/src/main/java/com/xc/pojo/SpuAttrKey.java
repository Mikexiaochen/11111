package com.xc.pojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class SpuAttrKey {
    private String key_id;
    private String key_name;
    private int key_issku;
    private int key_ishigh;
    private Date createtime;
    private Date updatetime;

    private List<SpuAttrValue> spuAttrValueList=new ArrayList<>();

    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getKey_id() {
        return key_id;
    }

    public void setKey_id(String key_id) {
        this.key_id = key_id;
    }

    public String getKey_name() {
        return key_name;
    }

    public void setKey_name(String key_name) {
        this.key_name = key_name;
    }

    public int getKey_issku() {
        return key_issku;
    }

    public void setKey_issku(int key_issku) {
        this.key_issku = key_issku;
    }

    public int getKey_ishigh() {
        return key_ishigh;
    }

    public void setKey_ishigh(int key_ishigh) {
        this.key_ishigh = key_ishigh;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public List<SpuAttrValue> getSpuAttrValueList() {
        return spuAttrValueList;
    }

    public void setSpuAttrValueList(List<SpuAttrValue> spuAttrValueList) {
        this.spuAttrValueList = spuAttrValueList;
    }

    @Override
    public String toString() {
        return "SpuAttrKey{" +
                "key_id='" + key_id + '\'' +
                ", key_name='" + key_name + '\'' +
                ", key_issku=" + key_issku +
                ", key_ishigh=" + key_ishigh +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                ", spuAttrValueList=" + spuAttrValueList +
                ", category=" + category +
                '}';
    }
}
