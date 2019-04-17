package com.jiang.jblog.controller;

import com.jiang.jblog.service.*;
import com.jiang.jblog.util.ResultInfo;
import com.jiang.jblog.vo.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 前台文章处理controller
 * FILE: com.jiang.jblog.controller.ArticleController.java
 * AUTHOR: jiang
 * DATE: 2017/5/8
 * TIME: 15:15
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private com.jiang.jblog.service.ArticleService articleService;  //文章service

    @Resource
    private com.jiang.jblog.service.PartnerService partnerService; //友情链接service

    @Resource
    private com.jiang.jblog.service.CategoryService categoryService; //分类service

    @Resource
    private com.jiang.jblog.service.TagService tagService;  //标签service

    @Resource
    private com.jiang.jblog.service.UserService userService;
    /**
     * 加载分页列表数据
     * @param pager
     * @param model
     * @return
     */
    @RequestMapping("/load")
    public String loadArticle(com.jiang.jblog.vo.Pager<com.jiang.jblog.vo.Article> pager, Model model){
        List<com.jiang.jblog.vo.ArticleCustom> articleList = articleService.articleList(pager);
        System.out.println(articleList);
        model.addAttribute("articleList",articleList);
        return "blog/part/articleSummary";
    }

    /**
     * 加载文章
     * 包括总标签数
     * 总文章数量
     * 分类及每个分类文章数量
     * 友链集合
     *
     * @return
     */
    @RequestMapping("/details/{articleId}")
    public String loadArticle(@PathVariable Integer articleId, Model model){
        List<com.jiang.jblog.vo.Partner> partnerList = partnerService.findAll();
        List<com.jiang.jblog.vo.CategoryCustom> categoryList = categoryService.initCategoryList();
        //上一篇
        com.jiang.jblog.vo.Article lastArticle = articleService.getLastArticle(articleId);
        //下一篇
        com.jiang.jblog.vo.Article nextArticle = articleService.getNextArticle(articleId);
        //增加浏览量
        articleService.addArticleCount(articleId);
        //获取文章总数量
        int articleCount = articleService.getArticleCount();
        //标签总数量
        int tagCount = tagService.getTagCount();
        //当前文章的所有信息
        com.jiang.jblog.vo.ArticleCustom articleCustom = articleService.getArticleCustomById(articleId);

        com.jiang.jblog.vo.UserInfo userInfo = userService.getUserInfo();

        model.addAttribute("lastArticle",lastArticle);
        model.addAttribute("nextArticle",nextArticle);
        model.addAttribute("article",articleCustom);
        model.addAttribute("categoryCount",categoryList.size());
        model.addAttribute("articleCount",articleCount);
        model.addAttribute("tagCount",tagCount);
        model.addAttribute("categoryList",categoryList);
        model.addAttribute("partnerList",partnerList);
        model.addAttribute("userInfo",userInfo);
        return "blog/article";
    }

    /**
     * 全局搜索
     * @param keyword 关键字
     * @param model
     * @return
     */
    @RequestMapping("/content/search")
    public String search(String keyword,Model model){
        List<com.jiang.jblog.vo.Article> articleList = articleService.getArticleListByKeywords(keyword);
        model.addAttribute("articleList",articleList);
        return "blog/part/search-info";
    }

}
