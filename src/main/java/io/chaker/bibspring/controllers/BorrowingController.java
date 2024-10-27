package io.chaker.bibspring.controllers;

import io.chaker.bibspring.models.Borrow;
import io.chaker.bibspring.services.BorrowingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BorrowingController {

    private final BorrowingService borrowingService;

    public BorrowingController(BorrowingService borrowingService) {
        this.borrowingService = borrowingService;
    }

    @GetMapping("/api/borrowings")
    public List<Borrow> getAllBorrowings() {
        return borrowingService.getAllBorrowings();
    }

    @GetMapping("/api/borrowings/{id}")
    public Borrow getBorrowing(@PathVariable Long id) {
        return borrowingService.getBorrowing(id);
    }

    @PostMapping("/api/borrowings")
    public void addBorrowing(@RequestBody Borrow borrow) {
        borrowingService.addBorrowing(borrow);
    }

    @PutMapping("/api/borrowings/{id}")
    public void updateBorrowing(@PathVariable Long id, @RequestBody Borrow borrow) {
        borrowingService.updateBorrowing(id, borrow);
    }

    @DeleteMapping("/api/borrowings/{id}")
    public void deleteBorrowing(@PathVariable Long id) {
        borrowingService.deleteBorrowing(id);
    }

    @DeleteMapping("/api/borrowings")
    public void deleteAllBorrowings() {
        borrowingService.deleteAllBorrowings();
    }
}