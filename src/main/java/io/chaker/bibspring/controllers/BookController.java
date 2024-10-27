package io.chaker.bibspring.controllers;


import io.chaker.bibspring.models.Book;
import io.chaker.bibspring.repositories.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private final BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/api/books")
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    @GetMapping("/api/books/{isbn}")
    public Book getBook(@PathVariable Long isbn) {
        return repository.findById(isbn).orElse(null);
    }

    @PostMapping("/api/books")
    public List<Book> addBooks(@RequestBody List<Book> books) {
        return repository.saveAll(books);
    }

    @PutMapping("/api/books/{isbn}")
    public Book updateBook(@PathVariable Long isbn,@RequestBody Book book) {
        return repository.findById(isbn)
                .map(b -> {
                    b.setTitle(book.getTitle());
                    b.setAuthor(book.getAuthor());
                    b.setYear(book.getYear());
                    return repository.save(b);
                })
                .orElse(null);
    }

    @DeleteMapping("/api/books/{isbn}")
    public void deleteBook(@PathVariable Long isbn) {
        repository.deleteById(isbn);
    }




}
