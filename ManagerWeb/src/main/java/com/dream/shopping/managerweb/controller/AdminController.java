package com.dream.shopping.managerweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dream.shopping.facade.IServiceFacade.IAdministerFacade;
import com.dream.shopping.facade.po.Administrator;
import com.dream.shopping.facade.vo.AdminVo;
import com.dream.shopping.managerweb.utils.WindowUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: sky
 * Date: 2018/11/24
 * Time: 11:07
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Reference(version = "1.0.0",timeout = 100000)
    private IAdministerFacade admin;

    @RequestMapping("/index")
    public String index(){
        return "login";
    }

    @RequestMapping("/login")
    public String login(AdminVo adminVo, Model model){
        Administrator administrator = admin.selectByAdmin(adminVo).get(0);
        if (administrator.getAdministratorName().equals(adminVo.getAdminCustomer().getAdministratorName()) &&
            administrator.getPassword().equals(adminVo.getAdminCustomer().getPassword())){
            model.addAttribute("admin",admin.selectByAdmin(adminVo).get(0));
            return "administrator/main";
        }else {
            return "login";
        }
    }

    @RequestMapping("/selectAll")
    public String selectAll(Model model){
        model.addAttribute("admins",admin.selectByAdmin(null));
        return "administrator/alladmins";
    }

    @RequestMapping("/query")
    public String query(AdminVo adminVo, Model model){
        System.out.println(adminVo);
        model.addAttribute("admins",admin.selectByAdmin(adminVo));
        return "administrator/alladmins";
    }

    @RequestMapping("/initAdmin")
    public String initAdmin(Integer administratorId, Model model){
        model.addAttribute("admin",admin.selectById(administratorId));
        return "administrator/update";
    }

    @RequestMapping("/updateAdmin")
    public void updateAdmin(Administrator administrator, HttpServletResponse resp){
        if (admin.updateAdmin(administrator) > 0){
            WindowUtil.window(resp,"更新成功","/admin/selectAll");
        }else {
            WindowUtil.window(resp,"更新失败","/admin/selectAll");
        }
    }

    @RequestMapping("/deleteAdmin")
    public void deleteAdmin(Integer administratorId, HttpServletResponse resp){
        if (admin.deleteAdminById(administratorId) > 0){
            WindowUtil.window(resp,"删除成功","/admin/selectAll");
        }else {
            WindowUtil.window(resp,"删除失败","/admin/selectAll");
        }
    }

    @RequestMapping("/add")
    public void add(Administrator administrator, HttpServletResponse resp){
        if (admin.insertAdmin(administrator) > 0){
            WindowUtil.window(resp,"添加成功","/admin/selectAll");
        }else {
            WindowUtil.window(resp,"添加失败","/admin/selectAll");
        }
    }

    @RequestMapping("/addAdmin")
    public String addAdmin(){
        return "administrator/add";
    }
}