package com.itheima;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest  //springboot整合单元测试的注解
class SpringbootMybatisQuickstart1ApplicationTests {
    @Autowired
    private UserMapper userMapper;

   @Test
   public void testListUser(){
       List<User> userList=userMapper.list();
       //用stream流的方式输出
       userList.stream().forEach(user -> {
           System.out.println(user);
       });
   }

}
