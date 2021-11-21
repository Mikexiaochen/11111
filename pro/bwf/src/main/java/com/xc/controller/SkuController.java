package com.xc.controller;

import com.xc.pojo.Sku;
import com.xc.pojo.Spu;
import com.xc.pojo.Vo;
import com.xc.pojo.Vo2;
import com.xc.service.SkuService;
import com.xc.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/sku")
public class SkuController {
    @Autowired
    private SpuService spuService;
    @Autowired
    private SkuService skuService;
    @RequestMapping("/admin")
    public void admin(Model model){
        //获取所有的spu列表
        List<Spu> spuList=spuService.getSpuList();
        model.addAttribute("spuList",spuList);
    }
    @RequestMapping("/update")
    public void update(Long spu_id,Model model){
        Spu spu=spuService.getSpuById(spu_id);

        model.addAttribute("spu",spu);
    }
    @RequestMapping("/getsku")
    @ResponseBody
    public Sku getsku(String vids, Long spu_id){
        String[] arrs=vids.split(",");
        //使用这三个value值去数据库获取指定的属性键和属性值 ，封装skuarr对象
        Sku sku=skuService.findSku(arrs,spu_id);

        return sku;
    }


    @ResponseBody
    @RequestMapping("/saveSku")
    public String saveSku(String vids,Long spu_id,Double skuprice,int kucun){
        String[] arrs=vids.split(",");
        String x=skuService.saveSku(arrs,spu_id,skuprice,kucun);
        return x;
    }
    @RequestMapping("/update2")
    public void update2(Long spu_id,Model model){
        Spu spu=spuService.getSpuById(spu_id);
        System.out.println(spu.getSpuAttrValueSpusList());
        model.addAttribute("spu",spu);
    }

    @ResponseBody
    @RequestMapping("/save")
    public String save(Vo vo){
        //上传数据库，以及上传图片到服务器
        for (Vo2 vo2:vo.getVo2List()) {
            System.out.println("每个value_id");
            System.out.println(vo2.getValue_id());//并且这个id对应的图片也都知道了，图片封装成数组

        }
        return "/common/success";
    }
}
