package com.leyla.spring_demo.DTO;

public class NoteResponseDTO {
    private Long id;
    private String content;
    private String title;

    public NoteResponseDTO(){}
    public NoteResponseDTO(Long id, String content, String title) {
        this.id = id;
        this.content = content;
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    
}
