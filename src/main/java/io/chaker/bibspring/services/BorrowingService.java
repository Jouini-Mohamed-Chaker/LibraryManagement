package io.chaker.bibspring.services;

import io.chaker.bibspring.models.Borrow;

import java.util.List;

public interface BorrowingService {
    void addBorrowing(Borrow borrow);
    void deleteBorrowing(Long id);
    void updateBorrowing(Long id, Borrow borrow);
    Borrow getBorrowing(Long id);
    List<Borrow> getAllBorrowings();
    void deleteAllBorrowings();
}