package com.itheima;

import com.example.HeaderGenerator;
import com.example.HeaderParser;
import com.example.TokenParser;
import com.google.gson.Gson;
import com.itheima.pojo.Result;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

/**
 * ClassName:AutoConfigurationTests
 * Package:com.itheima
 * Description:
 *
 * @Author zhuzhu
 * @Create 2024/4/14 18:59
 * @Version 1.0
 */
@SpringBootTest

public class AutoConfigurationTests {
    @Autowired
    private ApplicationContext applicationContext;
         //获取TokenParser
    @Test
    public void testTokenParser(){
        System.out.println(applicationContext.getBean(TokenParser.class));
    }
    //获取HeaderParser
    @Test
    public void testHeaderParser(){

        System.out.println(applicationContext.getBean(HeaderParser.class));
    }
    //获取HeaderGenerator
    @Test
    public void testHeaderGenerator(){
        System.out.println(applicationContext.getBean(HeaderGenerator.class));
    }

}
