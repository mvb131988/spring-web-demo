package com.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
              //(exclude = { DispatcherServletAutoConfiguration.class, 
              //                     ErrorMvcAutoConfiguration.class})
@ComponentScan(basePackages = {"com.main",
                               "com.example.demo.service",
                               "com.example.demo.controller3"})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
