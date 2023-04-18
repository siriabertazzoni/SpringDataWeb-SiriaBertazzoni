package it.data_web.spring_data_web.dto;

public class PostDTO {
    private String title;
    private String body;
    private String nomeAutore;
    private String cognomeAutore;
    private String emailAutore;

    
    public PostDTO() {
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
    public String getNomeAutore() {
        return nomeAutore;
    }
    public void setNomeAutore(String nomeAutore) {
        this.nomeAutore = nomeAutore;
    }
    public String getCognomeAutore() {
        return cognomeAutore;
    }
    public void setCognomeAutore(String cognomeAutore) {
        this.cognomeAutore = cognomeAutore;
    }
    public String getEmailAutore() {
        return emailAutore;
    }
    public void setEmailAutore(String emailAutore) {
        this.emailAutore = emailAutore;
    }
    

}
