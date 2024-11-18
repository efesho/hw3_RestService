package com.example.rest.dao;

import com.example.rest.model.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookDAOTest {
    private final BookDAO bookDAO = new BookDAO();

    @Test
    void testGetAllBooks() throws SQLException {
        List<Book> books = bookDAO.getAllBooks();
        assertNotNull(books);
    }

    @Test
    void testAddBook() throws SQLException, ParseException {
        Date publishedDate = Date.valueOf("2024-12-11"); // Это будет корректно работать в SQL
        Book book = new Book(0, "Test Book", publishedDate);
        bookDAO.addBook(book);

        List<Book> books = bookDAO.getAllBooks();
        assertTrue(books.stream().anyMatch((a -> "Test Book".equals(a.getTitle()))));
    }
}
