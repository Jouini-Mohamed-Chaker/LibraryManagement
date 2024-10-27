package io.chaker.bibspring.services;



import io.chaker.bibspring.models.Borrow;

import java.util.List;

public interface BorrowingService {
    void addBorrowing();
    void deleteBorrowing();
    void updateBorrowing();
    Borrow getBorrowing();
    List<Borrow> getAllBorrowings();
}
