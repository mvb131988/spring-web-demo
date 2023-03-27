package com.main;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.example.demo.controller1.AppConfig1;
import com.example.demo.controller2.AppConfig2;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;

//@Configuration
public class Initializer implements ServletContextInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        
        // Web context 1
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(AppConfig1.class);
        
        // Servlet1
        DispatcherServlet servlet = new DispatcherServlet(context);
        ServletRegistration.Dynamic registration = servletContext.addServlet("app", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/app1/*");
        
        // Web context 2
        AnnotationConfigWebApplicationContext context2 = new AnnotationConfigWebApplicationContext();
        context2.register(AppConfig2.class);
        
        // Servlet2
        DispatcherServlet servlet2 = new DispatcherServlet(context2);
        ServletRegistration.Dynamic registration2 = servletContext.addServlet("app2", servlet2);
        registration2.setLoadOnStartup(1);
        registration2.addMapping("/app2/*");
    }

}
