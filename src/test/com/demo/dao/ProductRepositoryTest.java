/*
package com.demo.dao;

import com.Application;
import com.demo.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

*/
/**
 * Created by Administrator on 2016/9/7.
 *//*

@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！
@SpringApplicationConfiguration(classes = Application.class) // 指定我们SpringBoot工程的Application启动类
@WebAppConfiguration
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository repository;

    @Test
    public void testFindByNameStartingWith() throws Exception {
        this.repository.deleteAll();

        // insert some products
        this.repository.save(new Product("1", "Nintendo Entertainment System"));
        this.repository.save(new Product("2", "Sega Megadrive"));
        this.repository.save(new Product("3", "Sony Playstation"));

        // fetch all
        System.out.println("Products found by findAll():");
        System.out.println("----------------------------");
        for (Product product : this.repository.findAll()) {
            System.out.println(product);
        }
        System.out.println();

        // fetch a single product
        System.out.println("Products found with findByNameStartingWith('So'):");
        System.out.println("--------------------------------");
        for (Product product : this.repository.findByNameStartingWith("So")) {
            System.out.println(product);
        }
        System.out.println();
    }

}*/
