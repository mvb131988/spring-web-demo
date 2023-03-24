package com.example.demo.controller;

import java.security.Provider.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.example.demo.common.Person;
import com.example.demo.service.MyService;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;

@RestController
class PersonController {

    @Autowired
    private ApplicationContext ctx;
    
    @Autowired
    private MyService service;
    
    @GetMapping("/app1/persons/{id}")
    public Person getPerson0(@PathVariable Long id, HttpServletRequest request) {
        return new Person();
    }

    @GetMapping("/persons/{id}")
    public Person getPerson1(@PathVariable Long id, HttpServletRequest request) {
        ServletContext sc = request.getServletContext();
        WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(sc);
//        PersonController pc = wac.getBean(PersonController.class);
        ApplicationContext parentCtx = ctx.getParent();
//        PersonController pc0 = parentCtx.getBean(PersonController.class);
        
        PersonController s2 = ctx.getBean(PersonController.class);
        PersonController s0 = wac.getBean(PersonController.class);
        PersonController s1 = parentCtx.getBean(PersonController.class);
        
        return new Person();
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody Person person) {
        
    }
}