package com.itheima.controller;

import com.itheima.anno.Log;
import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName:DeptController
 * Package:com.itheima.controller
 * Description:
 *
 * @Author zhuzhu
 * @Create 2024/4/1 16:51
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {
   // private static Logger log= LoggerFactory.getLogger(DeptController.class);
    //@RequestMapping(path="/depts",method = RequestMethod.GET)
    @Autowired
    private DeptService deptService;
    @GetMapping
    public Result list(){
        log.info("查询全部部门数据");
      //调用service查询部门数据
        List<Dept> deptList=deptService.list();
        return Result.success(deptList);
    }

    @Log
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) throws Exception {
        log.info("根据id删除部门:{}",id);
        //调用service进行删除
        deptService.delete(id);
        return Result.success();
    }

    //添加部门
    @Log
    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("增加部门:{}",dept);
        deptService.add(dept);
        return Result.success();
    }
    //根据ID查询部门
    @GetMapping ("/{id}")

    public Result selectById(@PathVariable Integer id){
        log.info("查询ID:{}",id);
        Dept dept=deptService.selectById(id);
        return Result.success(dept);
    }
    //修改部门
    @PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("修改部门：{}",dept);
        deptService.update(dept);
        return Result.success();
    }

    //员工信息的
}
