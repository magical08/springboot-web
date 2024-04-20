package com.itheima;
import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.common.auth.CredentialsProviderFactory;
import com.aliyun.oss.common.auth.EnvironmentVariableCredentialsProvider;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * ClassName:Demo
 * Package:com.itheima
 * Description:
 *
 * @Author zhuzhu
 * @Create 2024/4/8 16:00
 * @Version 1.0
 */
public class Demo {

        public static void main(String[] args) throws Exception {
            // Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。
            String endpoint = "https://oss-cn-beijing.aliyuncs.com";
            //阿里云账号AccessKey拥有所有API的访问权限，风险很高
            String accessKeyId="LTAI5tPP9Eivi7KctDHgo3L2";
            String accessKeySecret="I6TXOYLRZxrm9yjcBhNZ8zLfmpFxr1";
            // 填写Bucket名称，例如examplebucket。
            String bucketName = "hmleadnews0809";
            // 填写Object完整路径，完整路径中不能包含Bucket名称，例如exampledir/exampleobject.txt。
            String objectName = "1.jpg";
            // 填写本地文件的完整路径，例如D:\\localpath\\examplefile.txt。
            // 如果未指定本地路径，则默认从示例程序所属项目对应本地路径中上传文件流。
            String filePath= "C:\\Users\\17801\\Pictures\\Saved Pictures\\R-C.jpg";

            // 创建OSSClient实例。
            OSS ossClient = new OSSClientBuilder().build(endpoint,accessKeyId,accessKeySecret);

            try {
                InputStream inputStream = new FileInputStream(filePath);
                // 创建PutObjectRequest对象。
                PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, objectName, inputStream);
                // 创建PutObject请求。
                PutObjectResult result = ossClient.putObject(putObjectRequest);
            } catch (OSSException oe) {
                System.out.println("Caught an OSSException, which means your request made it to OSS, "
                        + "but was rejected with an error response for some reason.");
                System.out.println("Error Message:" + oe.getErrorMessage());
                System.out.println("Error Code:" + oe.getErrorCode());
                System.out.println("Request ID:" + oe.getRequestId());
                System.out.println("Host ID:" + oe.getHostId());
            } catch (ClientException ce) {
                System.out.println("Caught an ClientException, which means the client encountered "
                        + "a serious internal problem while trying to communicate with OSS, "
                        + "such as not being able to access the network.");
                System.out.println("Error Message:" + ce.getMessage());
            } finally {
                if (ossClient != null) {
                    ossClient.shutdown();
                }
            }
        }

}
