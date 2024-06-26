package com.itheima.dao.impl;

import com.itheima.dao.EmpDao;
import com.itheima.pojo.Emp;
import com.itheima.utils.XmlParserUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ClassName:EmpDaoA
 * Package:com.itheima.dao.impl
 * Description:
 *
 * @Author zhuzhu
 * @Create 2024/3/23 16:55
 * @Version 1.0
 */
//@Component   //将当前类交给IOC容器管理，成为IOC容器中的bean
   @Repository//("DaoA")
public class EmpDaoA implements EmpDao {
    @Override
    public List<Emp> listEmp() {
        //1. 加载并解析emp.xml
        String file=this.getClass().getClassLoader().getResource("emp.xml").getFile();
        System.out.println(file);
        List<Emp> empList= XmlParserUtils.parse(file,Emp.class);
        return empList;
    }
}
