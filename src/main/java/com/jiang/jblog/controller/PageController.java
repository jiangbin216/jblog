package com.jiang.jblog.controller;

import com.jiang.jblog.service.*;
import com.jiang.jblog.vo.ArticleCustom;
import com.jiang.jblog.vo.CategoryCustom;
import com.jiang.jblog.vo.Partner;
import com.jiang.jblog.vo.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 首页入口controller
 * FILE: com.jiang.jblog.controller.IndexController.java
 * AUTHOR: jiang
 * DATE: 2017/4/8
 * TIME: 15:19
 */
@Controller
public class  PageController {

    @Resource
    private com.jiang.jblog.service.PartnerService partnerService;  //友情链接的service

    @Resource
    private com.jiang.jblog.service.ArticleService articleService; //分钟信息的service

    @Resource
    private com.jiang.jblog.service.CategoryService categoryService;  //分类的service

    @Resource
    private com.jiang.jblog.service.TagService tagService;  //标签的service

    @Resource
    private com.jiang.jblog.service.UserService userService;

    /**
     * 首页
     * 初始化信息
     * 1.标签，分类，文章数量
     * 2.友情链接
     * 3.分类列表 -> 用于文章分类显示
     * 4.时间归档列表
     * @param model
     * @return
     */
    @RequestMapping("/")
    public String home(Model model){
        List<Partner> partnerList = partnerService.findAll();
        List<CategoryCustom> categoryList = categoryService.initCategoryList();
        UserInfo userInfo = userService.getUserInfo();
        int articleCount = articleService.getArticleCount();
        List<Map> archiveList = articleService.articleArchiveList();
        int tagCount = tagService.getTagCount();
        model.addAttribute("categoryCount",categoryList.size());
        model.addAttribute("articleCount",articleCount);
        model.addAttribute("tagCount",tagCount);
        model.addAttribute("categoryList",categoryList);
        model.addAttribute("partnerList",partnerList);
        model.addAttribute("archiveList",archiveList);
        model.addAttribute("userInfo",userInfo);
        return "blog/index";
    }

    /**
     * 分类排序 暂时停用
     * @return
     */
    @RequestMapping("/archives")
    @Deprecated
    public String archivesPage(){
        return "blog/archives";
    }

    /**
     * 跳转到登录页面
     * @return
     */
    @RequestMapping("/login")
    public String loginPage(){
        return "login";
    }

    /**跳转到友链展示页面
     * @return
     */
    @RequestMapping("/partner/list")
    public String partnerPage() {
        return "admin/partner/partnerList";
    }


    /**
     * 关于我跳转
     * @param model
     * @return
     */
    @RequestMapping("/about/me")
    public String aboutMe(Model model){
        List<Partner> partnerList = partnerService.findAll();
        List<CategoryCustom> categoryList = categoryService.initCategoryList();
        int articleCount = articleService.getArticleCount();
        int tagCount = tagService.getTagCount();
        model.addAttribute("categoryCount",categoryList.size());
        model.addAttribute("articleCount",articleCount);
        model.addAttribute("tagCount",tagCount);
        model.addAttribute("categoryList",categoryList);
        model.addAttribute("partnerList",partnerList);
        return "blog/aboutMe";
    }

    @RequestMapping("/popular")
    public String popularArticle(Model model){
        UserInfo userInfo = userService.getUserInfo();
        List<Partner> partnerList = partnerService.findAll();
        List<CategoryCustom> categoryList = categoryService.initCategoryList();
        int articleCount = articleService.getArticleCount();
        List<ArticleCustom> articleList = articleService.popularArticle();
        int tagCount = tagService.getTagCount();

        model.addAttribute("categoryCount",categoryList.size());
        model.addAttribute("articleCount",articleCount);
        model.addAttribute("tagCount",tagCount);
        model.addAttribute("articleList",articleList);
        model.addAttribute("categoryList",categoryList);
        model.addAttribute("partnerList",partnerList);
        model.addAttribute("userInfo",userInfo);
        return "blog/popular";
    }

    @RequestMapping("/thymeleaf")
    public String thymeleafPage(){
        return "blog/thymeleaf";
    }
}
