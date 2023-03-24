package com.example.demo.controller1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.Person;
import com.example.demo.controller2.ContextController2;

import jakarta.servlet.http.HttpServletRequest;

@RestController
class ContextController1 {

    @Autowired
    private ApplicationContext webContext;
    
    @GetMapping("/app1/context/{id}")
    public ResponseEntity<?> getPerson0(@PathVariable Long id, HttpServletRequest request) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/context/{id}")
    public ResponseEntity<?> getPerson1(@PathVariable Long id, HttpServletRequest request) {
        ApplicationContext rootContext = webContext.getParent();
        
        //case1
        @SuppressWarnings("unused")
        ContextController1 cc1 = webContext.getBean(ContextController1.class);
        //cc1 = parentCtx.getBean(ContextController1.class);
        
        //case2
        ContextController2 cc2 = webContext.getBean(ContextController2.class);
        //ContextController2 cc2 = rootContext.getBean(ContextController2.class);
        
        return ResponseEntity.ok().build();
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody Person person) {
        
    }
}