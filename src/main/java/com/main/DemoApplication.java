package com.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = { DispatcherServletAutoConfiguration.class, 
                                   ErrorMvcAutoConfiguration.class})
@ComponentScan(basePackages = {"com.main","com.example.demo.service"})
public class DemoApplication {

    @Autowired
    private ApplicationContext ac;
    
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
