package com.jiang.jblog.service.impl;

import com.jiang.jblog.mapper.ArticleMapper;
import com.jiang.jblog.mapper.PagerMapper;
import com.jiang.jblog.service.PagerService;
import com.jiang.jblog.vo.Pager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author jiang
 * @package com.jiang.jblog.service.impl
 * @name PagerServiceImpl
 * @date 2017/4/11
 * @time 21:46
 */
@Service
public class PagerServiceImpl implements PagerService {

    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private PagerMapper pagerMapper;
    @Override
    public void initPage(Pager pager) {
        int count = articleMapper.getArticleCount();
        pager.setTotalCount(count);
    }

    @Override
    public void loadCategoryPager(Pager pager,Integer categoryId) {
        int count = pagerMapper.loadCategoryPager(categoryId);
        pager.setTotalCount(count);
    }

    @Override
    public void loadTagPager(Pager pager, Integer tagId) {
        int count = pagerMapper.loadTagPager(tagId);
        pager.setTotalCount(count);
    }
}
