package com.xc.controller;

import com.xc.pojo.Category;
import com.xc.pojo.brand;
import com.xc.service.BrandService;
import com.xc.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BrandService brandService;
    @RequestMapping("admin")
    public void admin(Model model){
        List<Category> categoryList=categoryService.findAllCategory();
        model.addAttribute("categoryList",categoryList);
    }
    @RequestMapping("add")
    public void add(Integer cate_id,Model model){
        //根据分类的id,添加插入操作
        model.addAttribute("cate_id",cate_id);

        //获取所有的品牌
        List<brand> brandList=brandService.findBrand();
        model.addAttribute("brandList",brandList);
    }
    @RequestMapping("save")
    public String save(Category c,Integer brand_id,String [] key_name){

        /*System.out.println(Arrays.toString(key_name));
        System.out.println("品牌名:"+brand_id);*/
        c.setCreatetime(new Date());
        c.setUpdatetime(new Date());
        System.out.println(c);

        //往数据库添加分类
        //添加分类和品牌的关系
        //添加当前分类的筛选属性键
        categoryService.saveCategory(c,brand_id,key_name);
        return "/common/success";
    }
}
