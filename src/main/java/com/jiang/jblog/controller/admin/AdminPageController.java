package com.jiang.jblog.controller.admin;

import com.jiang.jblog.service.*;
import com.jiang.jblog.vo.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * 后端管理的页面跳转controller
 * FILE: com.jiang.jblog.controller.admin.AdminPageController.java
 * AUTHOR: jiang
 * DATE: 2017/4/9
 * TIME: 21:55
 */
@Controller
@RequestMapping("/admin")
public class AdminPageController {

    @Resource
    private com.jiang.jblog.service.ArticleService articleService;

    @Resource
    private com.jiang.jblog.service.CategoryService categoryService;

    @Resource
    private com.jiang.jblog.service.TagService tagService;

    @Resource
    private com.jiang.jblog.service.PartnerService partnerService;

    @Resource
    private com.jiang.jblog.service.UserService userService;
    /**
     * 后台首页
     * @return
     */
    @RequestMapping("/home")
    public String homePage(){
        return "redirect:/admin/article/list";
    }

    /**
     * 跳转到文章列表页面
     * @return
     */
    @RequestMapping("/article/list")
    public String articlePage(Model model){
        List<Tag> tagList = tagService.getTagList();
        List<Category> categoryList = categoryService.getCategoryList();
        com.jiang.jblog.vo.UserInfo userInfo = userService.getUserInfo();
        model.addAttribute("userInfo",userInfo);
        model.addAttribute("tagList",tagList);
        model.addAttribute("categoryList",categoryList);
        return "admin/article/articleList";
    }


    /**
     * 跳转标签展示页面
     * @param model
     * @return
     */
    @RequestMapping("/tag/list")
    public String labelPage(Model model){
        com.jiang.jblog.vo.UserInfo userInfo = userService.getUserInfo();
        model.addAttribute("userInfo",userInfo);
        return "admin/label/labelList";
    }
    /**
     * 加载友链分页
     * @param pager
     * @param model
     * @return
     */
    @RequestMapping("/partner/load")
    public String loadPartner(com.jiang.jblog.vo.Pager pager, Model model, String param){
        pager.setStart((pager.getPage()-1)*pager.getLimit());
        List<com.jiang.jblog.vo.Partner> partnerList =partnerService.loadPartner(pager,param);
        model.addAttribute("partnerList",partnerList);
        return "admin/partner/partnerTable";
    }

    /**
     * 跳转添加友链页面
     * @return
     */
    @RequestMapping("/partner/addJump")
    public String partnerAddPage(){
        return "admin/partner/partnerAdd";
    }

    @RequestMapping("/partner/editJump/{id}")
    public String partnerEditPage(@PathVariable Integer id, Model model){
        com.jiang.jblog.vo.Partner partner = partnerService.getPartnerById(id);
        model.addAttribute("partner",partner);
        return "admin/partner/partnerEdit";
    }

    /**
     * 跳转到分类列表页面
     * @return 分类列表页面
     */
    @RequestMapping("/category/list")
    public String categoryPage(Model model){
        com.jiang.jblog.vo.UserInfo userInfo = userService.getUserInfo();
        model.addAttribute("userInfo",userInfo);
        return "admin/category/categoryList";
    }


    /**跳转到友链展示页面
     * @return
     */
    @RequestMapping("/partner/list")
    public String partnerPage(Model model){
        com.jiang.jblog.vo.UserInfo userInfo = userService.getUserInfo();
        model.addAttribute("userInfo",userInfo);
        return "admin/partner/partnerList";
    }

    @RequestMapping("/test")
    public String testPage(){
        return "admin/test";
    }
}
