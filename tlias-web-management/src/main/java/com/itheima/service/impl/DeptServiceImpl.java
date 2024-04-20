package com.itheima.service.impl;

import com.itheima.mapper.DeptMapper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Dept;
import com.itheima.pojo.DeptLog;
import com.itheima.service.DeptLogService;
import com.itheima.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * ClassName:DeptServiceImpl
 * Package:com.itheima.service.impl
 * Description:
 *
 * @Author zhuzhu
 * @Create 2024/4/1 16:57
 * @Version 1.0
 */
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private DeptLogService deptLogService;

    @Override
    //查询所有部门
    public List<Dept> list() {
        return deptMapper.list();
    }

    @Transactional(rollbackFor = Exception.class)  //spring事务管理
    @Override
    //删除部门
    public void delete(Integer id) throws Exception {

        try {
            deptMapper.deleteById(id) ;  //根据ID删除部门数据
            //int i=1/0;
            // if(true){ throw new Exception ("出错啦..."); }

            empMapper.deleteByDeptId(id); //根据部门ID删除该部门下的员工


        } finally {
            DeptLog deptLog=new DeptLog();
            deptLog.setCreateTime(LocalDateTime.now());
            deptLog.setDescription("执行了解解散部门的操作，此次解散的是"+id+"号部门");
            deptLogService.insert(deptLog);
        }
    }

    @Override
    //添加部门
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
        return;
    }

    @Override
    //根据ID查询部门
    public Dept selectById(Integer id) {
        return deptMapper.select(id);
    }

    @Override
    //修改部门
    public void update(Dept dept) {
        Dept dept1=deptMapper.select(dept.getId());
        dept1.setName(dept.getName());
        dept1.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept1);

    }
}
