package com.leyla.spring_demo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController{
    @GetMapping("/selam")
    public String selam(){
        return "Spring Boot Öğreniyorum!";
    }
}