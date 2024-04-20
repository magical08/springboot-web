package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * ClassName:EmpServiceImpl
 * Package:com.itheima.service.impl
 * Description:
 *
 * @Author zhuzhu
 * @Create 2024/4/1 16:57
 * @Version 1.0
 */
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
    /*@Override
    public PageBean page(Integer page, Integer pageSize) {

        //获取总记录数
        PageBean pageBean=new PageBean();
        pageBean.setTotal(empMapper.count());
        //获取每页的记录
        Integer start=(page-1)*pageSize;
        //封装PageBean对象
        pageBean.setRows(empMapper.page(start,pageSize));

;
        return pageBean;
    }*/
    @Override
    public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        // 1.设置分页参数
        PageHelper.startPage(page,pageSize);

        // 2.执行查询
        List<Emp> empList=empMapper.list(name, gender, begin,end);
        Page<Emp> p=(Page<Emp>) empList;
        // 3.封装PageBean对象
        PageBean pageBean=new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }

    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }

    @Override
    public void save(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);
    }

    @Override
    public Emp select(Integer id) {
        /*Emp emp=empMapper.select(id);
        return emp;*/
        return empMapper.select(id);
    }

    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }

    @Override
    public Emp login(Emp emp) {

        return empMapper.getByUsernameAndPassword(emp);
    }
}
