package ch.hftm.blog.dto;

public class NewEntryDto {
    public NewEntryDto() {
    }
    public NewEntryDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
    private String title;
    private String content;
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    
}
