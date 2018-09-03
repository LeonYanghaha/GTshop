package com.greentrust;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
// 配置基础包，spring将会自动扫描这些包。
// 此外，spring会自动扫描启动类之下的包，也就是说：如果将这些包都写在启动类的下一级包中，那么这个配置就可以不写
@ComponentScan(basePackages = {"com.greentrust"})
//配置mapper的包
@MapperScan("com.greentrust.dao")
// 开启事务
@EnableTransactionManagement
//开启定时任务---同步
@EnableScheduling
//开启定时任务--异步
@EnableAsync
//maxInactiveIntervalInSeconds session超时时间,单位秒
//@EnableRedisHttpSession/*(maxInactiveIntervalInSeconds = 600)*/

public class ShopApplication {

    public static void main(String[] args) {

        SpringApplication.run(ShopApplication.class, args);
    }
}
