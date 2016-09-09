package com.baymax.dao;

import com.Application;
import com.baymax.entity.CheckEntry;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016/9/9.
 */
@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！
@SpringApplicationConfiguration(classes = Application.class) // 指定我们SpringBoot工程的Application启动类
@WebAppConfiguration
public class CheckEntryDaoTest {
    @Resource
    private CheckEntryDao checkEntryDao;
    @Test
    public void testFindAllByParentId() throws Exception {
        List<CheckEntry> checkEntryList = checkEntryDao.findAllBySqlParentId(0l);
        System.out.println("+++++++=");
    }
}