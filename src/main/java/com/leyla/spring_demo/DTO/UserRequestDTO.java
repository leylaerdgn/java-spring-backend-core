package com.leyla.spring_demo.DTO;

public class UserRequestDTO {
    private String name;
    
    public UserRequestDTO(){}
    public UserRequestDTO(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
        }
}
