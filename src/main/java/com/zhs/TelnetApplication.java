package com.zhs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@MapperScan(basePackages = "com.zhs.mapper")
/*@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})*/
public class TelnetApplication {

    public static void main(String[] args) {
        SpringApplication.run(TelnetApplication.class, args);
    }
}
