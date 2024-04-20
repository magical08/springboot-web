package com.itheima.aop;

import com.alibaba.fastjson.JSONObject;
import com.itheima.mapper.OperateLogMapper;
import com.itheima.pojo.OperateLog;
import com.itheima.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * ClassName:LogAspect
 * Package:com.itheima.aop
 * Description:
 *定义一个切面类，把通知放在里面
 * @Author zhuzhu
 * @Create 2024/4/13 18:02
 * @Version 1.0
 */
@Component
@Aspect  //切面方法
@Slf4j
public class LogAspect {
    @Autowired
    private OperateLogMapper operateLogMapper;
    @Autowired
    private HttpServletRequest request;


    @Around("@annotation(com.itheima.anno.Log)")
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {
        //操作人ID  --当前登录员工ID
        //获取请求头中的JWT令牌，解析令牌  令牌包含登录员工的id，姓名，用户名
        String jwt= request.getHeader("token");
        Claims claims= JwtUtils.parseJWT(jwt);
        Integer operateUser=(Integer) claims.get("id");

        //操作时间
        LocalDateTime operateTime=LocalDateTime.now();

        //操作类名
        String className=joinPoint.getTarget().getClass().getName();
        //操作方法名
        String methodName=joinPoint.getSignature().getName();

        //操作方法参数
        Object[] args=joinPoint.getArgs();
        String methodParams= Arrays.toString(args);

        //原始方法运行前时间
        long begin=System.currentTimeMillis();
        //调用原始目标方法运行
        Object result=joinPoint.proceed();

        //原始方法运行后时间
        long end=System.currentTimeMillis();
        //操作方法返回值
        String returnValue= JSONObject.toJSONString(result);
        //操作耗时
        Long costTime=end-begin;

        //记录操作日志
        OperateLog operateLog=new OperateLog(null,operateUser,operateTime,className,methodName,methodParams,returnValue,costTime);
        operateLogMapper.insert(operateLog);

        log.info("AOP记录操作日志:{}",operateLog);

        return result;
    }
}
