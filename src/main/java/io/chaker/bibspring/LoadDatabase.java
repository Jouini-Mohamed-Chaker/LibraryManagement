package io.chaker.bibspring;

import io.chaker.bibspring.models.Book;
import io.chaker.bibspring.repositories.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(BookRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Book("The Great Gatsby", "F. Scott Fitzgerald", 9780684830421L, 1925)));
            log.info("Preloading " + repository.save(new Book("To Kill a Mockingbird", "Harper Lee", 9780061120084L, 1960)));
        };
    }

}
