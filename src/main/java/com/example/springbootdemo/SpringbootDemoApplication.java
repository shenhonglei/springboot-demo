package com.example.springbootdemo;

import net.unicon.cas.client.configuration.EnableCasClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBootApplication
 */
@SpringBootApplication()
@EnableCasClient
public class SpringbootDemoApplication {

    /**
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoApplication.class, args);
    }
}
