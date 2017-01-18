package com.bm.resource;

import com.bm.dao.ArticleDao;
import com.bm.entity.Article;

import com.bm.model.ResultModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedHashMap;

/**
 * Created by Administrator on 2017/1/17.
 */
@Controller
@RequestMapping("/article")
@Api(value = "文章模块",description = "文章模块")
public class ArticleResource {

    @Autowired
    private ArticleDao articleDao;

    @RequestMapping("/save")
    @ResponseBody
    @ApiOperation(value = "创建文章",httpMethod = "POST")
    public ResultModel insert(@ApiParam(required = true,name = "jsonData",value = "文章对象json字符串") String jsonData){
        Article article = new Article();
        article.setJsonData(jsonData);
        return new ResultModel(0,"success",new LinkedHashMap()).put("article",articleDao.save(article));
    }

    @RequestMapping("/list")
    @ResponseBody
    @ApiOperation(value = "文章分页列表",httpMethod = "GET")
    public ResultModel list(@ApiParam(required = true,name = "page",value = "页码")@RequestParam int page,
                            @ApiParam(required = true,name = "rows",value = "偏移量")@RequestParam int rows){
        PageRequest pageRequest = new PageRequest(page-1,rows,null);
        Page<Article> checkEntryPage = this.articleDao.findAll(pageRequest);
        return new ResultModel(0,"success",new LinkedHashMap()).put("articleList",checkEntryPage);
    }

    @RequestMapping("/getOnly")
    @ResponseBody
    @ApiOperation(value = "查看文章",httpMethod = "GET")
    public ResultModel only(@ApiParam(required = true,name = "id",value = "文章id")long id){
        return new ResultModel(0,"success",new LinkedHashMap()).put("article",articleDao.findOne(id));
    }


}
