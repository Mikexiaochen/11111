package com.xc.controller;

import com.xc.pojo.SpuAttrKey;
import com.xc.service.SpuAttrKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/attr")
public class AttrController {
    @Autowired
    private SpuAttrKeyService spuAttrKeyService;
    @RequestMapping("/admin")
    public void admin(Model model){
        /*获取所有的属性键*/
        List<SpuAttrKey> spuAttrKeyList=spuAttrKeyService.findAllSpuAttrKey();
        model.addAttribute("spuAttrKeyList",spuAttrKeyList);
    }
    @RequestMapping("/update")
    public void update(String key_id,Model model){
        //根据当前key_id获取当前的属性键对象
        //根据当前key_id获取属性值列表
        SpuAttrKey spuAttrKey=spuAttrKeyService.findSpuAttrKey(key_id);
        System.out.println(spuAttrKey);
        model.addAttribute("spuAttrKey",spuAttrKey);
    }
    @RequestMapping("/save")
    public String save(SpuAttrKey spuAttrKey,String [] value_name){
        /*System.out.println(spuAttrKey);
        System.out.println(Arrays.toString(value_name));*/
        //根据当前属性键修改数据库
        spuAttrKeyService.updataSpuKey(spuAttrKey,value_name);
        //根据当前属性值修改属性键对应的属性值
        return  "/common/success";
    }
}
