package io.chaker.bibspring.repositories;

import io.chaker.bibspring.models.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowingRepository extends JpaRepository<Borrow, Long> {
}
