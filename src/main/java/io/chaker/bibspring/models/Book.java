package io.chaker.bibspring.models;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;

public class Book {
    private String title;
    private String author;

    @Id private String isbn;

    private Integer year;

    public Book(String title, String author, String isbn, Integer year) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public Integer getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", year=" + year +
                '}';
    }

}
