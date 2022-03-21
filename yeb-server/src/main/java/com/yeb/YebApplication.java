package com.yeb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 启动类
 */
@SpringBootApplication
@MapperScan("com.yeb.mapper")
@EnableScheduling
public class YebApplication {
    public static void main(String[] args) {
        SpringApplication.run(YebApplication.class);
    }
}
