package com.example.demo.controller2;

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

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class ContextController2 {

    @Autowired
    private ApplicationContext ctx;
    
    @GetMapping("/app2/context/{id}")
    public ResponseEntity<?> getPerson0(@PathVariable Long id, HttpServletRequest request) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/context/{id}")
    public ResponseEntity<?> getPerson1(@PathVariable Long id, HttpServletRequest request) {
        ApplicationContext parentCtx = ctx.getParent();
        
        ContextController2 cc2 = ctx.getBean(ContextController2.class);
        //ContextController2 cc2 = parentCtx.getBean(ContextController2.class);
        
        return ResponseEntity.ok().build();
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody Person person) {
        
    }
    
}
