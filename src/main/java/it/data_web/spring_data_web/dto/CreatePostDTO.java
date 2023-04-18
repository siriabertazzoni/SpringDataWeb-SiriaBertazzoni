package it.data_web.spring_data_web.dto;

public class CreatePostDTO {
    private String title;
    private String body;
    private String publishDate;
    private Long autoriId;
    
    public CreatePostDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public Long getAutoriId() {
        return autoriId;
    }

    public void setAutoriId(Long autoriId) {
        this.autoriId = autoriId;
    }

    
}
