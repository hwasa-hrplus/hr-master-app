package com.poscoict.hrmaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class HRMasterApplication {
    public static void main( String[] args ) {
        SpringApplication.run(HRMasterApplication.class , args);
    }
}
