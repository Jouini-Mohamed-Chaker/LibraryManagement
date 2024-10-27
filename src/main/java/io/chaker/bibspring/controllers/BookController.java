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

    @GetMapping("/api/books/{id}")
    public Book getBook(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping("/api/books")
    public List<Book> addBooks(@RequestBody List<Book> books) {
        return repository.saveAll(books);
    }

    @PutMapping("/api/books/{id}")
    public Book updateBook(@PathVariable Long id,@RequestBody Book book) {
        return repository.findById(id)
                .map(b -> {
                    b.setTitle(book.getTitle());
                    b.setAuthor(book.getAuthor());
                    b.setYear(book.getYear());
                    return repository.save(b);
                })
                .orElse(null);
    }

    @DeleteMapping("/api/books/{id}")
    public void deleteBook(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @DeleteMapping("/api/books")
    public void deleteAllBooks() {
        repository.deleteAll();
    }




}
