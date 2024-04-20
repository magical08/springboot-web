package com.itheima.pojo;

import lombok.*;

import java.time.LocalDateTime;

/**
 * ClassName:Dept
 * Package:com.itheima.pojo
 * Description:部门实体类
 *
 * @Author zhuzhu
 * @Create 2024/4/1 16:53
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dept {
     private Integer id;
     private String name;
     private LocalDateTime createTime;
     private LocalDateTime updateTime;
}
