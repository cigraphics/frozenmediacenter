package net.frozenlogic.mediacenter.impl.plugins.goodreads;

import java.math.BigDecimal;

public class SearchResult {
    private Book bestBook;
    private Integer ratingsCount;
    private BigDecimal averageRating;

    public Book getBestBook() {
        return bestBook;
    }

    public void setBestBook(Book bestBook) {
        this.bestBook = bestBook;
    }

    public Integer getRatingsCount() {
        return ratingsCount;
    }

    public void setRatingsCount(Integer ratingsCount) {
        this.ratingsCount = ratingsCount;
    }

    public BigDecimal getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(BigDecimal averageRating) {
        this.averageRating = averageRating;
    }
}
