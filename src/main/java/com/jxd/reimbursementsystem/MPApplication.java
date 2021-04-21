package com.jxd.reimbursementsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description:
 * @author: wxwty168
 * @date: 2020/12/18 10:12
 */
@SpringBootApplication
@MapperScan("com.jxd.reimbursementsystem.dao")
public class MPApplication {
    public static void main(String[] args) {
        SpringApplication.run(MPApplication.class);
    }
}
