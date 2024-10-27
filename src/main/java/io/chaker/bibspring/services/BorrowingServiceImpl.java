package io.chaker.bibspring.services;

import io.chaker.bibspring.models.Borrow;
import io.chaker.bibspring.models.Book;
import io.chaker.bibspring.models.Student;
import io.chaker.bibspring.repositories.BorrowingRepository;
import io.chaker.bibspring.repositories.BookRepository;
import io.chaker.bibspring.repositories.StudentRepository;
import jakarta.persistence.Column;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowingServiceImpl implements BorrowingService {

    private static final Logger logger = LoggerFactory.getLogger(BorrowingServiceImpl.class);

    private final BorrowingRepository borrowingRepository;
    private final BookRepository bookRepository;
    private final StudentRepository studentRepository;

    public BorrowingServiceImpl(BorrowingRepository borrowingRepository, BookRepository bookRepository, StudentRepository studentRepository) {
        this.borrowingRepository = borrowingRepository;
        this.bookRepository = bookRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public void addBorrowing(Borrow borrow) {
        logger.info("Adding borrowing: {}", borrow);
        Optional<Book> book = bookRepository.findById(borrow.getBookId());
        Optional<Student> student = studentRepository.findById(borrow.getStudentId());

        if (book.isPresent() && student.isPresent()) {
            borrowingRepository.save(borrow);
        } else {
            throw new IllegalArgumentException("Invalid book ID or student ID");
        }
    }

    @Override
    public void deleteBorrowing(Long id) {
        logger.info("Deleting borrowing with ID: {}", id);
        borrowingRepository.deleteById(id);
    }

    @Override
    public void updateBorrowing(Long id, Borrow borrow) {
        logger.info("Updating borrowing with ID: {}", id);
        Optional<Borrow> existingBorrow = borrowingRepository.findById(id);
        if (existingBorrow.isPresent()) {
            Optional<Book> book = bookRepository.findById(borrow.getBookId());
            Optional<Student> student = studentRepository.findById(borrow.getStudentId());

            if (book.isPresent() && student.isPresent()) {
                Borrow updatedBorrow = existingBorrow.get();
                updatedBorrow.setBookId(borrow.getBookId());
                updatedBorrow.setStudentId(borrow.getStudentId());
                updatedBorrow.setBorrowDate(borrow.getBorrowDate());
                updatedBorrow.setReturnDate(borrow.getReturnDate());
                borrowingRepository.save(updatedBorrow);
            } else {
                throw new IllegalArgumentException("Invalid book ID or student ID");
            }
        } else {
            throw new IllegalArgumentException("Borrowing not found");
        }
    }

    @Override
    public Borrow getBorrowing(Long id) {
        logger.info("Fetching borrowing with ID: {}", id);
        return borrowingRepository.findById(id).orElse(null);
    }

    @Override
    public List<Borrow> getAllBorrowings() {
        logger.info("Fetching all borrowings");
        return borrowingRepository.findAll();
    }

    @Override
    public void deleteAllBorrowings() {
        logger.info("Deleting all borrowings");
        borrowingRepository.deleteAll();
    }

}