package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * ClassName:Emp
 * Package:com.itheima.pojo
 * Description:
 *
 * @Author zhuzhu
 * @Create 2024/3/30 14:55
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    private Integer id;  //ID
    private String username;  //用户名
    private String password; //密码
    private String name;  //姓名
    private Short gender;  //性别
    private String image;  //图像url
    private Short job;   //职位 ，说明：1 班主任 2 讲师 3 学工主管 4 教研主管 5 咨询师
    private LocalDate entrydate;  //入职时间
    private Integer deptId;  //部门ID
    private LocalDateTime createTime;  //创建时间
    private LocalDateTime updateTime; //修改时间

}
