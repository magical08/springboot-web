package com.itheima.mapper;

import com.itheima.pojo.Dept;
import lombok.Data;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * ClassName:DeptMapper
 * Package:com.itheima.mapper
 * Description:
 *
 * @Author zhuzhu
 * @Create 2024/4/1 16:52
 * @Version 1.0
 */
@Mapper
public interface DeptMapper {
    //查询全部部门数据
    @Select("select * from tlia.dept")
    List<Dept> list();

    //根据ID删除部门
    @Delete("delete from tlia.dept where id=#{id}")

    void deleteById(Integer id);


    //添加部门
    @Insert("insert into tlia.dept(name, create_time, update_time) values " +
            "(#{name},#{createTime},#{updateTime}) ")
    void insert(Dept dept);

    //根据ID 查询部门
    @Select("select * from tlia.dept where id=#{id}")
    Dept select(Integer id);

    //修改部门
    @Update("update tlia.dept set name=#{name},update_time=#{updateTime} where id=#{id}")
    void update(Dept dept);
}
