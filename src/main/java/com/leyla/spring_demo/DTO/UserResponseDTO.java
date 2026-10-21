package com.leyla.spring_demo.DTO;

public class UserResponseDTO {
    private Long id;
    private String name;

    public UserResponseDTO(){}
    public UserResponseDTO(Long id, String name){
        this.id=id;
        this.name=name;
    }

    public Long getId(){
        return id;
    }
    public String getName(){
        return name;
    }

    public void setId(Long id){
        this.id=id;
    }

    public void setName(String name){
        this.name=name;
    }
}
