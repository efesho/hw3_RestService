package com.example.rest.dao;

import com.example.rest.config.DatabaseConfig;
import com.example.rest.model.AuthorBook;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorBookDAO {
    public void addAuthorBook(AuthorBook authorBook) throws SQLException {
        String query = "INSERT INTO author_books (author_id, book_id) VALUES (?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, authorBook.getAuthorId());
            stmt.setInt(2, authorBook.getBookId());
            stmt.executeUpdate();
        }
    }

    public void deleteAuthorBook(int authorId, int bookId) throws SQLException {
        String query = "DELETE FROM author_books WHERE author_id = ? AND book_id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, authorId);
            stmt.setInt(2, bookId);
            stmt.executeUpdate();
        }
    }

    public List<AuthorBook> getAuthorBooksByAuthorId(int authorId) throws SQLException {
        String query = "SELECT * FROM author_books WHERE author_id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, authorId);
            try (ResultSet rs = stmt.executeQuery()) {
                List<AuthorBook> authorBooks = new ArrayList<>();
                while (rs.next()) {
                    authorBooks.add(new AuthorBook(rs.getInt("author_id"), rs.getInt("book_id")));
                }
                return authorBooks;
            }
        }
    }

    public List<AuthorBook> getAuthorBooksByBookId(int bookId) throws SQLException {
        String query = "SELECT * FROM author_books WHERE book_id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, bookId);
            try (ResultSet rs = stmt.executeQuery()) {
                List<AuthorBook> authorBooks = new ArrayList<>();
                while (rs.next()) {
                    authorBooks.add(new AuthorBook(rs.getInt("author_id"), rs.getInt("book_id")));
                }
                return authorBooks;
            }
        }
    }
}
