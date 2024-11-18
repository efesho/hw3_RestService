package com.example.rest.dao;

import com.example.rest.config.DatabaseConfig;
import com.example.rest.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    public List<Book> getAllBooks() throws SQLException {
        String query = "SELECT * FROM books";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            List<Book> books = new ArrayList<>();
            while (rs.next()) {
                books.add(new Book(rs.getInt("book_id"), rs.getString("title"), rs.getDate("published_date")));
            }
            return books;
        }
    }

    public void addBook(Book book) throws SQLException {
        String query = "INSERT INTO books (title) VALUES (?)";
        try (Connection conn = DatabaseConfig.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, book.getTitle());
            stmt.executeUpdate();
        }
    }
}
