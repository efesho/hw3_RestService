package com.example.rest.dao;

import com.example.rest.config.DatabaseConfig;
import com.example.rest.model.Author;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorDAO {
    public List<Author> getAllAuthors() throws SQLException {
        String query = "SELECT * FROM authors";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            List<Author> authors = new ArrayList<>();
            while (rs.next()) {
                authors.add(new Author(rs.getInt("author_id"), rs.getString("name")));
            }
            return authors;
        }
    }

    public void addAuthor(Author author) throws SQLException {
        String query = "INSERT INTO authors (name) VALUES (?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, author.getName());
            stmt.executeUpdate();
        }
    }
}
