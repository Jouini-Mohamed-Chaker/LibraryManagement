package io.chaker.bibspring.repositories;

import io.chaker.bibspring.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
