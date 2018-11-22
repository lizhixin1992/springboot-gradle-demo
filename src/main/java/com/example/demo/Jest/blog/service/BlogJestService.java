package com.example.demo.Jest.blog.service;

import com.example.demo.Jest.blog.domain.Blog;
import com.example.demo.Jest.blog.param.SearchParam;
import com.example.demo.Jest.core.base.JestDataBaseService;
import com.example.demo.Jest.core.result.SmartSearchResult;

/**
 * @desc jestSearch
 **/
public interface BlogJestService extends JestDataBaseService<Blog> {

    /**
     * 通用查询
     */
    SmartSearchResult<Blog> queryBySearchParam(SearchParam searchParam);
}
