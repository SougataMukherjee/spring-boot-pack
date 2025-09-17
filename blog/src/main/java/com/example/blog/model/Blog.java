package com.example.blog.model;

public class Blog {
    private Integer id;
    private String title;
    private String description;
    private String content;
    private String imageUrl;

    public Blog(Integer id, String title, String description, String content, String imageUrl) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.content = content;
        this.imageUrl = imageUrl;
    }

    // getters and setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}
