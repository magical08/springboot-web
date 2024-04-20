package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

/**
 //<editor-fold desc="Description">
 * ClassName:EmpMapper
 //</editor-fold>
 * Package:com.itheima.mapper
 * Description:
 *
 * @Author zhuzhu
 * @Create 2024/3/30 15:02
 * @Version 1.0
 */
@Mapper
public interface EmpMapper {

     //根据ID删除数据
    @Delete("delete from emp where id=#{id}")
     public void delete(Integer id);


    //新增员工
    @Options(keyProperty = "id",useGeneratedKeys = true)  //会自动将生成的主键值，赋值给emp对象的id属性


    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time)" +
            "values(#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    public void insert(Emp emp);

    //更新数据
    @Update("update emp set username=#{username},name=#{name},gender=#{gender},image=#{image}," +
            "job=#{job},entrydate=#{entrydate},dept_id=#{deptId},update_time=#{updateTime} where id=#{id}")

    public void update(Emp emp);

    //解决方案三：开启mybatis的驼峰命名自动映射开关  --- a_cloumn ----> aColumn



    //根据ID查询员工,由于数据库的dept_id,create_time,update_time与封装类的相应字段名称不一样，运行出来的结果导致这三个字段的值为null

    @Select("select * from emp where id=#{id}")
    public Emp getById(Integer id);

    //解决方案一：给字段起别名，让别名与实体类属性一致
    /*@Select("select id, username, password, name, gender, image, job, entrydate, " +
            "dept_id deptId , create_time createTime, update_time updateTime from emp where id=#{id}")
    public Emp getById(Integer id);*/

    //解决方案二：通过@Results,@Result注解手动映射封装
    /*@Results({
            @Result(column = "dept_id",property = "deptId"),
            @Result(column = "create_time",property = "createTime"),
            @Result(column = "update_time",property = "updateTime")
    })
    @Select("select * from emp where id=#{id}")
    public Emp getById(Integer id);*/


    //条件查询员工
    /*@Select("select * from emp" +
            " where name like '%${name}%' and gender=#{gender} and entrydate between #{begin} and #{end}" +
            " order by update_time desc ")
    public List<Emp> list(String name, Short gender, LocalDate begin,LocalDate end);*/

    /*@Select("select * from emp" +
            " where name like concat('%',#{name},'%') and gender=#{gender} and entrydate between #{begin} and #{end}" +
            " order by update_time desc ")
    public List<Emp> list(String name, Short gender, LocalDate begin,LocalDate end);*/
    public List<Emp> list(String name, Short gender, LocalDate begin,LocalDate end);


    //动态更新员工信息
    public void update2(Emp emp);

    //批量删除员工
    public void deleteByIds(List<Integer> ids);
}


