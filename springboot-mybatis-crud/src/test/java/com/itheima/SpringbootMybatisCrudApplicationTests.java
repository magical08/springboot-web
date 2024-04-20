package com.itheima;

import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class SpringbootMybatisCrudApplicationTests {
    @Autowired
    private EmpMapper empMapper;

    @Test
    public void testDelete(){
        // int delete=empMapper.delete(16);
        // System.out.println(delete);
        empMapper.delete(16);
    }
    @Test
    public void testInsert(){
        Emp emp =new Emp();
        emp.setUsername("Tom2");
        emp.setName("汤姆2");
        emp.setImage("1.jpg");
        emp.setGender((short)1);
        emp.setJob((short)1);
        emp.setEntrydate(LocalDate.of(2000,1,1));
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);

        //执行新增员工操作
        empMapper.insert(emp);
        System.out.println(emp.getId());

    }
    //更新员工
    @Test
    public void testUpdate(){
        //构造员工信息
        Emp emp =new Emp();
        emp.setId(21);
        emp.setUsername("Tom1");
        emp.setName("汤姆1");
        emp.setImage("1.jpg");
        emp.setGender((short)1);
        emp.setJob((short)1);
        emp.setEntrydate(LocalDate.of(2000,1,1));
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);

        //执行更新员工操作
        empMapper.update(emp);
    }
    @Test
    //根据ID查询员工
    public void testGetById(){
        Emp emp=empMapper.getById(21);
        System.out.println(emp);
    }
    //根据条件查询员工  ---动态查询
    @Test
    public void testList(){
        //List<Emp> empList= empMapper.list("张",(short)1,LocalDate.of(2010,1,1),LocalDate.of(2020,1,1));
       // List<Emp> empList= empMapper.list("张",null,null,null);
        // List<Emp> empList= empMapper.list("张",(short)1,null,null);
       // List<Emp> empList= empMapper.list(null,(short)1,null,null);
        List<Emp> empList= empMapper.list(null,null,null,null);
        System.out.println(empList);
    }

    //动态更新员工- 更新ID=21的员工  username改为Tom111,name改为汤姆111，gender更新为2
    @Test
    public void testUpdate2(){
        //构造员工信息
        Emp emp =new Emp();
        emp.setId(22);
        emp.setUsername("Tom1223");
        //emp.setName("汤姆122");
        //emp.setGender((short)2);
        //emp.setUpdateTime(LocalDateTime.now());


        //执行更新员工操作
        empMapper.update2(emp);
    }

    //批量删除员工- 13，14，15
    @Test
    public void deleteByIds(){
        List<Integer> ids= Arrays.asList(13,14,15);
        empMapper.deleteByIds(ids);
    }
}