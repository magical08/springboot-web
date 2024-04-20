package com.example;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HeaderConfig {

    @Bean
    //@ConditionalOnClass(name = "io.jsonwebtoken.Jwts")  //环境中存在指定的这个类，才会将该bean加入IOC容器中
    //@ConditionalOnMissingBean   //不存在该类型的bean，才会将该bean加入IOC容器中  ---可以根据指定的类型和名称来判断
    @ConditionalOnProperty(name="name",havingValue = "itheima") //配置文件中存在指定的属性与值，才会将该bean加入IOC容器中

    public HeaderParser headerParser(){
        return new HeaderParser();
    }

    @Bean
    public HeaderGenerator headerGenerator(){
        return new HeaderGenerator();
    }
}
