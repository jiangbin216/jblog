package com.jiang.jblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * com.jiang.jblog.Application.java
 *
 * @author:jiang
 * @year: 2017
 * @month: 04
 * @day: 02
 * @time: 2017/4/2
 */
@SpringBootApplication
@EnableScheduling
public class JBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(JBlogApplication.class,args);
    }
}
