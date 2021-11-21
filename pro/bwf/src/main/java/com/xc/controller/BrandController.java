package com.xc.controller;

import com.xc.pojo.brand;
import com.xc.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @RequestMapping("/admin")
    public void admin(Model model){
        List<brand> brandList=brandService.findBrand();
        model.addAttribute("brandList",brandList);
    }
}
