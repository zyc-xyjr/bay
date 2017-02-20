package com.bm.service.impl;

import com.Application;
import com.bm.service.PushService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/2/9.
 */
@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！
@SpringApplicationConfiguration(classes = Application.class) // 指定我们SpringBoot工程的Application启动类
@WebAppConfiguration
public class PushServiceImplTest {

    @Autowired
    private PushService pushService;

    @Test
    public void testPushMsg() throws Exception {
        pushService.pushMsg("c0a89df1c12555db05788c6b37c26092",1l);

    }
}