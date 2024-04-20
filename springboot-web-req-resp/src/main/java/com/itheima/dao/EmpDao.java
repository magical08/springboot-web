package com.itheima.dao;

import com.itheima.pojo.Emp;

import java.util.List;

/**
 * ClassName:EmpDao
 * Package:com.itheima.dao
 * Description:
 *
 * @Author zhuzhu
 * @Create 2024/3/23 16:53
 * @Version 1.0
 */
public interface EmpDao {
    //获取员工列表数据
    public List<Emp> listEmp();

}
