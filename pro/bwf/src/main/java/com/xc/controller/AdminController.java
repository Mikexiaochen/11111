package com.xc.controller;

import com.xc.common.Common;
import com.xc.pojo.Admin;
import com.xc.pojo.Role;
import com.xc.service.IAdminService;
import com.xc.service.RoleService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class  AdminController {
    @Autowired
    private IAdminService adminService;

    @Autowired
    private RoleService roleService;

    @RequestMapping("/login")
    public void login(){

    }
    @RequestMapping("/dologin")
    public void dologin(String username,String password){
        //正常这边去数据库查询操作，但是目前交给springSecurity进行管理，所以当前方法只是用来绑定用户名和密码
        //这个方法仅仅用来接收参数
    }
    @RequestMapping("/logout")
    public void logout(){

    }
    /*员工管理*/
    @RequestMapping("/admin")
    public void admin(Model model){
        List<Admin> adminList=adminService.findAllAdmin();
        model.addAttribute("adminList",adminList);
    }
    /*添加员工*/
    @RequestMapping("/add")
    public void add(Model model){
        //为员工添加要执行的角色
        //获取角色列表
        List<Role> roleList=roleService.findAllRole();
        model.addAttribute("roleList",roleList);
    }
    /*添加员工执行*/
    @RequestMapping("/save")
    public String save(Admin admin,Integer[] role_id){
       /* System.out.println(admin.getAdmin_name());
        System.out.println(admin.getAdmin_nickname());
        System.out.println(Arrays.toString(role_id));*/
        String password=new BCryptPasswordEncoder().encode(Common.Default_ADMIN_PASSWORD);
        admin.setAdmin_pass(password);
        adminService.saveAdmin(admin,role_id);
        return "redirect:/admin/admin";
    }
    /*编辑员工执行*/
    @RequestMapping("/update")
    public void update(Integer admin_id,Model model){

        //获取当前修改的员工
        Admin admin=adminService.findAdminById(admin_id);
        model.addAttribute("admin",admin);
    }
    /*编辑员工提交*/
    @RequestMapping("/alter")
    public String alter(Admin admin,Integer[] role_id){
        //更新用户
        adminService.updateAdmin(admin,role_id);

        return "/common/success";
    }
    /*员工删除操作*/
    @RequestMapping("/delete")
    public String delete(Integer admin_id){
        adminService.deleteAdmin(admin_id);
        return "/common/success";
    }
    /*员工查询*/
    @RequestMapping("/query")
    public String query(Admin admin,Model model,HttpSession session){
        List<Admin> adminList=adminService.findAllAdmin(admin);
        model.addAttribute("adminList",adminList);

        //保存查询到的adminlist数据到session，为导出准备
        session.setAttribute("adminList",adminList);

        model.addAttribute("admin_id",admin.getAdmin_id());
        model.addAttribute("admin_name",admin.getAdmin_name());
        model.addAttribute("admin_nickname",admin.getAdmin_nickname());

        return "/admin/admin";
    }

    /*文件导出操作*/
    @RequestMapping("/export")
    public void export(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Admin> adminList= (List<Admin>) session.getAttribute("adminList");
        System.out.println("用户列表："+adminList);
        //创建表格并导出
        HSSFWorkbook workbook=new HSSFWorkbook();
        HSSFSheet sheet=workbook.createSheet("员工信息");

        //创建行列
        //创建首行
        HSSFRow row0=sheet.createRow(0);
        HSSFCell cell0=row0.createCell(0);
        HSSFCell cell1=row0.createCell(1);
        HSSFCell cell2=row0.createCell(2);
        cell0.setCellValue("用户id");
        cell1.setCellValue("用户姓名");
        cell2.setCellValue("用户昵称");
        //读取数据
        if(adminList!=null){
            for(int i=0;i<adminList.size();i++){
                HSSFRow rowx=sheet.createRow(1+i);
                HSSFCell cellx0=rowx.createCell(0);
                HSSFCell cellx1=rowx.createCell(1);
                HSSFCell cellx2=rowx.createCell(2);
                cellx0.setCellValue(adminList.get(i).getAdmin_id());
                cellx1.setCellValue(adminList.get(i).getAdmin_name());
                cellx2.setCellValue(adminList.get(i).getAdmin_nickname());
            }
        }
        /*String adminname=authentication.getName();//获取用户名
        File filename=new File("D://",adminname+'.xls');*/
        String fileName="admin.xls";
        File file=new File("D:\\admin.xls");
        workbook.write(new FileOutputStream(file));
        workbook.close();
        //文件下载
        //response.setContentType(request.getServletContext().getMimeType(fileName));
        //解决文件下载的中文乱码问题
        //判断浏览器的类型
        String header = request.getHeader("User-Agent");

        //设置要被下载的文件的文件名
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        //使用IO技术，将数据发送（使用response对象发送数据）
        //获取输入流，读取文件数据
        FileInputStream in = new FileInputStream(file);
        //获取输出流，写出文件数据
        ServletOutputStream out = response.getOutputStream();
        //定义一个缓冲区
        byte[] buf = new byte[1024];
        while(in.read(buf) != -1){
            out.write(buf);
        }
        in.close();
    }
}

