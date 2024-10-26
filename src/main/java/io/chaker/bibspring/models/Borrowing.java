package io.chaker.bibspring.models;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;

public class Borrowing {
    @Id private String borrowingId;
     private String bookId;
    private String userId;
    private String borrowingDate;
    private String returnDate;
    private boolean isReturned;

    public Borrowing(String borrowingId, String bookId, String userId, String borrowingDate, String returnDate, boolean isReturned) {
        this.borrowingId = borrowingId;
        this.bookId = bookId;
        this.userId = userId;
        this.borrowingDate = borrowingDate;
        this.returnDate = returnDate;
        this.isReturned = isReturned;
    }

    public String getBorrowingId() {
        return borrowingId;
    }

    public String getBookId() {
        return bookId;
    }

    public String getUserId() {
        return userId;
    }

    public String getBorrowingDate() {
        return borrowingDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public boolean isReturned() {
        return isReturned;
    }

    @Override
    public String toString() {
        return "Borrowing{" +
                "borrowingId='" + borrowingId + '\'' +
                ", bookId='" + bookId + '\'' +
                ", userId='" + userId + '\'' +
                ", borrowingDate='" + borrowingDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                ", isReturned=" + isReturned +
                '}';
    }
}
