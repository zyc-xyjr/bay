package com.demo.dao;

import com.Application;
import com.demo.entity.Invest;
import com.demo.entity.Loan;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016/9/18.
 */
@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！
@SpringApplicationConfiguration(classes = Application.class) // 指定我们SpringBoot工程的Application启动类
@WebAppConfiguration
public class InvestDaoTest {

    @Autowired
    private InvestDao investDao;

    @Test
    public void testFindAll() throws Exception {
        Page<Invest> loen=investDao.findAll(new PageRequest(0,10));
        System.out.println("+++++++++");
    }
}