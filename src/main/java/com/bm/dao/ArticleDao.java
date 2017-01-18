package com.bm.dao;

import com.bm.entity.Article;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Administrator on 2017/1/17.
 */
public interface ArticleDao extends PagingAndSortingRepository<Article,Long> {
}
