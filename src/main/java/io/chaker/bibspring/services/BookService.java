package io.chaker.bibspring.services;

import io.chaker.bibspring.models.Book;

import java.util.List;

public interface BookService {
    void addBook();
    void deleteBook();
    void updateBook();
    Book getBook();
    List<Book> getAllBooks();
}
