package com.xc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/common")
public class CommonController {

    @RequestMapping("/permissionerror")
    public void permissionerror(){

    }
}
