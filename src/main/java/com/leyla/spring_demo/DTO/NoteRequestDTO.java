package com.leyla.spring_demo.DTO;

public class NoteRequestDTO {
    private String content;
    private String title;

    public NoteRequestDTO(){}

    public NoteRequestDTO(String content, String title) {
        this.content = content;
        this.title = title;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }


    
}
