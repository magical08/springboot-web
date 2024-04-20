package com.itheima.service;

import com.itheima.pojo.Dept;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName:DeptService
 * Package:com.itheima.service
 * Description:
 *
 * @Author zhuzhu
 * @Create 2024/4/1 16:56
 * @Version 1.0
 */

public interface DeptService {
    //查询全部部门数据

    List<Dept> list();

    void delete(Integer id) throws Exception;


    //新增部门
    void add(Dept dept);

    Dept selectById(Integer id);

    void update(Dept dept);
}
