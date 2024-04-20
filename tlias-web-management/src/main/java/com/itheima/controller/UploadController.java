package com.itheima.controller;

import com.itheima.pojo.Result;
import com.itheima.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * ClassName:UploadController
 * Package:com.itheima.controller
 * Description:
 *
 * @Author zhuzhu
 * @Create 2024/4/7 16:56
 * @Version 1.0
 */
@RestController
@Slf4j
public class UploadController {
    @Autowired
    private AliOSSUtils aliOSSUtils;
    //本地存储
    /*@PostMapping("/upload")
    public Result upload(String username, Integer age, MultipartFile image) throws Exception {
          log.info("文件上传:{},{},{}",username,age,image);
          //获取文件原始名
          String originalFilename = image.getOriginalFilename();

          //构造唯一的文件名(不能重复) -uuid(通用唯一识别码) 305adf17-0c7f-4306-bd35-ef1c32333086
          int index=originalFilename.lastIndexOf(".");
          String extname=originalFilename.substring(index);
          String newFileName= UUID.randomUUID().toString()+extname;
          log.info("新的文件名:{}",newFileName);
          //将文件存储在服务器的磁盘目录中  D:\javawork\javaweb-itheima\resources\images
          image.transferTo(new File("D:\\javawork\\javaweb-itheima\\resources\\images\\"+newFileName));
          return Result.success();
    }*/
    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException {
       log.info("文件上传,文件名:{}",image.getOriginalFilename());
       //调用阿里云oss工具类进行文件上传
       String url=aliOSSUtils.upload(image);
       log.info("文件上传完成，文件访问的url:{}",url);
       return Result.success(url);
    }
}
