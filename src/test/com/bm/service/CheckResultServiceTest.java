package com.bm.service;

import com.Application;
import com.bm.entity.CheckResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016/12/13.
 */
@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！
@SpringApplicationConfiguration(classes = Application.class) // 指定我们SpringBoot工程的Application启动类
@WebAppConfiguration
public class CheckResultServiceTest {

    @Autowired
    private CheckResultService checkResultService;

    @Test
    public void testSaveCheckResult() throws Exception {
        CheckResult checkResult = new CheckResult();

        checkResult.setCheckValue(55.2f);
        checkResult.setEntryId(22l);
        checkResult.setHealthFormId(1l);
        CheckResult checkResult1 = checkResultService.saveCheckResult(checkResult);
        System.out.println("");

    }
}