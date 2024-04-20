package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * ClassName:PageBean
 * Package:com.itheima.pojo
 * Description:
 *分页查询封装类
 * @Author zhuzhu
 * @Create 2024/4/2 16:05
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageBean {
    private Long total;  //总记录数
    private List rows;   //数据列表

}
