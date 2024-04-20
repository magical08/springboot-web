package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

/**
 * ClassName:EmpMapper
 * Package:com.itheima.mapper
 * Description:
 *
 * @Author zhuzhu
 * @Create 2024/4/1 16:52
 * @Version 1.0
 */
@Mapper
public interface EmpMapper {

   /* //查询总记录数
    @Select("select count(*) from tlia.emp")
    public Long count();

    //每页的记录数
    @Select("select * from tlia.emp limit #{start},#{pageSize}")
    public List<Emp> page(Integer start,Integer pageSize);*/

    //员工信息的查询

    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    //批量删除员工的id

    void delete(List<Integer> ids);


    //新增员工
    @Insert("insert into tlia.emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time)" +
            "values(#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);

    //根据id查询员工
    @Select("select * from tlia.emp where id=#{id}")
    Emp select(Integer id);

    void update(Emp emp);
    //根据用户名和密码查询员工
    @Select("select * from emp where username=#{username} and password=#{password}")
    Emp getByUsernameAndPassword(Emp emp);


    //根据部门ID删除该部门下的员工数据

    @Delete("delete from tlia.emp where dept_id=#{deptId} ")
    void deleteByDeptId(Integer deptId);
}
