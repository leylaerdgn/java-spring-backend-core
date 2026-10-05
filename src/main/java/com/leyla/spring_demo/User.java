package com.leyla.spring_demo;

public class User {
    private String name;
    private Long id;
    
    public User(){}
    public User(String name, Long id){
        this.name=name;
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public Long getId(){
        return id;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setId(Long id){
        this.id=id;
    }
}
