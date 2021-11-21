package com.xc.pojo;

import java.util.ArrayList;
import java.util.List;

public class Vo {
    List<KeyValue> list=new ArrayList<>();
    List<Vo2> vo2List=new ArrayList<>();

    public List<Vo2> getVo2List() {
        return vo2List;
    }

    public void setVo2List(List<Vo2> vo2List) {
        this.vo2List = vo2List;
    }

    public List<KeyValue> getList() {
        return list;
    }

    public void setList(List<KeyValue> list) {
        this.list = list;
    }
}