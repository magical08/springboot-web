package com.itheima.mapper;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * ClassName:UserMapper
 * Package:com.itheima.mapper
 * Description:
 *
 * @Author zhuzhu
 * @Create 2024/3/30 13:13
 * @Version 1.0
 */
//mapper包相当于dao包
@Mapper  //当前是mybatis当中的mapper接口，在运行时，会自动生成该接口的实现类对象（代理对象），并将该对象交给IOC容器管理
public interface UserMapper {
    //查询全部的用户信息
    @Select("select * from user")
    public List<User> list();

}
