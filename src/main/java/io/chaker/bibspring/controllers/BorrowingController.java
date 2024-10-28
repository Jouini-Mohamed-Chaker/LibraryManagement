package io.chaker.bibspring.controllers;

import io.chaker.bibspring.models.Borrow;
import io.chaker.bibspring.repositories.BorrowingRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BorrowingController {

    private final BorrowingRepository borrowingRepository;

    public BorrowingController(BorrowingRepository borrowingRepository) {
        this.borrowingRepository = borrowingRepository;
    }

    @GetMapping("/api/borrowings")
    public List<Borrow> getAllBorrowings() {
        return borrowingRepository.findAll();
    }

    @GetMapping("/api/borrowings/{id}")
    public Borrow getBorrowing(@PathVariable Long id) {
        return borrowingRepository.findById(id).orElse(null);
    }

    @PostMapping("/api/borrowings/addMany")
    public List<Borrow> addBorrowings(@RequestBody List<Borrow> borrowings) {
        return borrowingRepository.saveAll(borrowings);
    }
    
    @PostMapping("/api/borrowings/addOne")
    public Borrow addBorrowings(@RequestBody Borrow borrowing) {
        return borrowingRepository.save(borrowing);
    }

    @PutMapping("/api/borrowings/{id}")
    public Borrow updateBorrowing(@PathVariable Long id, @RequestBody Borrow borrow) {
        return borrowingRepository.findById(id)
                .map(b -> {
                    b.setStudentId(borrow.getStudentId());
                    b.setBookId(borrow.getBookId());
                    b.setBorrowDate(borrow.getBorrowDate());
                    b.setReturnDate(borrow.getReturnDate());
                    return borrowingRepository.save(b);
                })
                .orElse(null);
    }

    @DeleteMapping("/api/borrowings/{id}")
    public void deleteBorrowing(@PathVariable Long id) {
        borrowingRepository.deleteById(id);
    }

    @DeleteMapping("/api/borrowings")
    public void deleteAllBorrowings() {
        borrowingRepository.deleteAll();
    }
}
