package com.xc.pojo;

import org.springframework.web.multipart.MultipartFile;

public class Vo2 {
    private Long value_id; //一个value_id对应着多个图片
    private MultipartFile[] spuattrimages;

    public Long getValue_id() {
        return value_id;
    }

    public void setValue_id(Long value_id) {
        this.value_id = value_id;
    }

    public MultipartFile[] getSpuattrimages() {
        return spuattrimages;
    }

    public void setSpuattrimages(MultipartFile[] spuattrimages) {
        this.spuattrimages = spuattrimages;
    }
}
