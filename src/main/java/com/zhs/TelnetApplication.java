package com.zhs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.zhs.mapper")
public class TelnetApplication {

    public static void main(String[] args) {
        SpringApplication.run(TelnetApplication.class, args);
    }
}
