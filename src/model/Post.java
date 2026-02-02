package model;

public class Post {
    private String id;
    private String title;
    private String content;
    private String author;
    private String createdDate;

    public Post(){}

    public Post(String id, String title, String content, String author, String createdDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.createdDate = createdDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return id + " | " +
                title + " | " +
                author + " | " +
                createdDate;
    }

    public String toFileString() {
        return id + "," + title + "," + author + "," + createdDate;
    }
}
