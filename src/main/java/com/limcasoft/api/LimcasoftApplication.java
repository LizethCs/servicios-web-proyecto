package com.limcasoft.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.limcasoft.api", "com.limcasoft.api.config"})
public class LimcasoftApplication {

    public static void main(String[] args) {
        SpringApplication.run(LimcasoftApplication.class, args);
    }

}
