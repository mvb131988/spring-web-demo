package com.main;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.example.demo.common.AppConfig;
import com.example.demo.controller2.AppConfig2;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;

@Configuration
public class Initializer implements ServletContextInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

//        // Create the 'root' Spring application context
//        AnnotationConfigWebApplicationContext rootContext =
//          new AnnotationConfigWebApplicationContext();
//        rootContext.register(AppConfig.class);
//        
//        // Manage the lifecycle of the root application context
////        servletContext.addListener(new ContextLoaderListener(rootContext));
        
        // Create the dispatcher servlet's Spring application context
//        AnnotationConfigWebApplicationContext dispatcherContext =
//          new AnnotationConfigWebApplicationContext();
//        dispatcherContext.register(AppConfig.class);
        //////////////////////////////////////////////////////////////////////////////////////
        
        // Load Spring web application configuration
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(AppConfig.class);
        
        // Create and register the DispatcherServlet
        DispatcherServlet servlet = new DispatcherServlet(context);
        ServletRegistration.Dynamic registration = servletContext.addServlet("app", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/app1/*");
        
        // Load Spring web application configuration
        AnnotationConfigWebApplicationContext context2 = new AnnotationConfigWebApplicationContext();
        context2.register(AppConfig2.class);
        
        // Create and register the DispatcherServlet
        DispatcherServlet servlet2 = new DispatcherServlet(context2);
        ServletRegistration.Dynamic registration2 = servletContext.addServlet("app2", servlet2);
        registration2.setLoadOnStartup(1);
        registration2.addMapping("/app2/*");
    }

}
