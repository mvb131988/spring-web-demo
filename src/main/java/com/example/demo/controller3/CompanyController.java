package com.example.demo.controller3;

import java.io.IOException;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.common.ChannelType;
import com.example.demo.common.Company;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class CompanyController {

    private Logger logger = LoggerFactory.getLogger(CompanyController.class);
    
    @GetMapping("/app3/company/{id}")
    public ResponseEntity<Company> getCompany(@PathVariable Long id,  
                                              @RequestHeader("User-Agent") String agent) 
    {
        logger.info("Get handler for /app3/company/{id}");
        
        Company c = new Company("company1", 
                                new BigInteger("300000007228142"), 
                                ChannelType.PHONE, 
                                UUID.fromString("74edef69-3ae3-4cf9-ae16-a2e6a2ddc698"), 
                                true,
                                LocalDateTime.now());
        return ResponseEntity.ok().body(c);
    }
    
    @GetMapping("/app3/company")
    public ResponseEntity<?> getCompanyByDate(@RequestParam LocalDateTime time) {
        //null value: serialization config
        Company c = new Company("company1", 
                new BigInteger("300000007228142"), 
                ChannelType.PHONE, 
                UUID.fromString("74edef69-3ae3-4cf9-ae16-a2e6a2ddc698"), 
                true,
                null);
        return ResponseEntity.ok().body(c);
    }

    @PostMapping("/app3/company/")
    public ResponseEntity<?> saveCompany(@RequestBody Company c) {
        return ResponseEntity.ok().build();
    }
    
    @PutMapping("/app3/company/{id}/categoryId/{categoryId}")
    public ResponseEntity<?> updateCompany(@PathVariable Long id, @PathVariable Long categoryId) {
        return ResponseEntity.ok().build();
    }
    
    @DeleteMapping("/app3/company/{id}")
    public ResponseEntity<?> deleteCompany(@PathVariable Long id, HttpServletResponse response) {
        
        response.setHeader("Compnay-status", "DEACTIVATED");
        
        return ResponseEntity.ok().build();
    }
    
    @PostMapping("/app3/company-file/")
    public ResponseEntity<?> saveCompanyFile(@RequestParam("myfile") MultipartFile file) throws IOException 
    {
        if (!file.isEmpty()) {
            byte[] bytes = file.getBytes();
            // store the bytes somewhere
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    
}
