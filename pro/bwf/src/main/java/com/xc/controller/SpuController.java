package com.xc.controller;

import com.xc.pojo.*;
import com.xc.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/spu")
public class SpuController {
    @Autowired
    private SpuService spuService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SpuAttrKeyService spuAttrKeyService;

    @Autowired
    private SpuAttrValueService spuAttrValueService;
    @RequestMapping("/admin")
    public void admin(Model model){
        List<Spu> spuList =spuService.getSpuList();
        model.addAttribute("spuList",spuList);
    }
    @RequestMapping("/add")
    public void add(Model model){
        List<brand> brand=brandService.findBrand();
        model.addAttribute("brands",brand);
        List<Category> categoryList=categoryService.findAllCategory();
        model.addAttribute("categoryList",categoryList);
    }
    @RequestMapping("/getcate")
    @ResponseBody
    public List<Category> getCateList(Integer pid){
        return categoryService.findCateById(pid);
    }

    @ResponseBody
    @RequestMapping("/getattrKey")
    public List<SpuAttrKey> getAttrKeyList(Integer cate_id){
        return spuAttrKeyService.findSpuAttrKeyById(cate_id);
    }

    @RequestMapping("/getattrValue")
    @ResponseBody
    public List<SpuAttrValue> getAttrValue(String key_id){

        return spuAttrValueService.findValueById(key_id);
    }

    /**
     *
     * @param spu
     * @param cate_id
     * @param spu_brand_id
     * @param value_id
     * @param vo 添加的属性 以及属性值列表
     */
    @RequestMapping("/save")
    public String save(Spu spu,String spu_brand_id,Integer cate_id,Integer[] value_id,Vo vo){
        /*System.out.println(spu);
        System.out.println(spu_brand_id);
        System.out.println(Arrays.toString(value_id));
        System.out.println(vo.getList().get(0).getKeyn());
        System.out.println(Arrays.toString(vo.getList().get(0).getValuen()));*/
        spuService.saveSpu(spu,spu_brand_id,cate_id,value_id,vo);
        return "/common/success";
    }
    //进入修改详情页面，根据spu的id查询spu
    @RequestMapping("/update")
    public void update(Long spu_id,Model model){
        Spu spu=spuService.getSpuById(spu_id);

        model.addAttribute("spu",spu);
        model.addAttribute("brands",brandService.findBrand());
    }
}
