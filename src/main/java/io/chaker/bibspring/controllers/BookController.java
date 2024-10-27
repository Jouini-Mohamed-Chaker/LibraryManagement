package io.chaker.bibspring.controllers;


import io.chaker.bibspring.models.Book;
import io.chaker.bibspring.repositories.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/api/books")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/api/books/{id}")
    public Book getBook(@PathVariable Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @PostMapping("/api/books")
    public List<Book> addBooks(@RequestBody List<Book> books) {
        return bookRepository.saveAll(books);
    }

    @PutMapping("/api/books/{id}")
    public Book updateBook(@PathVariable Long id,@RequestBody Book book) {
        return bookRepository.findById(id)
                .map(b -> {
                    b.setTitle(book.getTitle());
                    b.setAuthor(book.getAuthor());
                    b.setYear(book.getYear());
                    return bookRepository.save(b);
                })
                .orElse(null);
    }

    @DeleteMapping("/api/books/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }

    @DeleteMapping("/api/books")
    public void deleteAllBooks() {
        bookRepository.deleteAll();
    }




}
