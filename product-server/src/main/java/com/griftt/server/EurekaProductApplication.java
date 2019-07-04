package com.griftt.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.griftt"})
@EnableDiscoveryClient
@EnableJpaRepositories("com.griftt.common.repository")
@EntityScan("com.griftt.common.entity")
public class EurekaProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaProductApplication.class, args);
    }
}
