package com.example.springconfigclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Set;

@SpringBootApplication
@EnableScheduling
public class SpringConfigClientApplication {
    @Autowired
    private ContextRefresher contextRefresher;

    public static void main(String[] args) {
        SpringApplication.run(SpringConfigClientApplication.class, args);
    }


   // @Scheduled(fixedRate = 3000, initialDelay = 5000)
    public  void refreshConfig(){
        Set<String> keys = contextRefresher.refresh();
        for(String key : keys){
            System.out.println("配置更新了："+key);
        }
    }

    @Bean
    public HealthIndicator healthIndicator(){
        return new MyHealthIndicator();
    }
}
