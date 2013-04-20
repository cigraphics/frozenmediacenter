package net.frozenlogic.mediacenter.impl.goodreads;

public class Book {

    private Integer idBook;
    private Author author;
    private String fullCoverUrl;
    private String thumbnailCoverUrl;
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getIdBook() {
        return idBook;
    }

    public void setIdBook(Integer idBook) {
        this.idBook = idBook;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getFullCoverUrl() {
        return fullCoverUrl;
    }

    public void setFullCoverUrl(String fullCoverUrl) {
        this.fullCoverUrl = fullCoverUrl;
    }

    public String getThumbnailCoverUrl() {
        return thumbnailCoverUrl;
    }

    public void setThumbnailCoverUrl(String thumbnailCoverUrl) {
        this.thumbnailCoverUrl = thumbnailCoverUrl;
    }
}
