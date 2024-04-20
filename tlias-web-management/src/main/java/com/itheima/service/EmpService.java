package com.itheima.service;

import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * ClassName:EmpService
 * Package:com.itheima.service
 * Description:
 *
 * @Author zhuzhu
 * @Create 2024/4/1 16:56
 * @Version 1.0
 */

public interface EmpService {

    //分页查询
    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin,LocalDate end);



    //批量删除员工
    void delete(List<Integer> ids);


    //新增员工
    void save(Emp emp);


    //根据id查询员工信息
    Emp select(Integer id);

    //更新员工

    void update(Emp emp);


    //登录操作
    Emp login(Emp emp);
}
