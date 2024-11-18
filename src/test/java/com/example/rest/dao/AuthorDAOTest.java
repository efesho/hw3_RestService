package com.example.rest.dao;

import com.example.rest.model.Author;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AuthorDAOTest {
    private final AuthorDAO authorDAO = new AuthorDAO();

    @Test
    void testGetAllAuthors() throws SQLException {
        List<Author> authors = authorDAO.getAllAuthors();
        assertNotNull(authors);
    }

    @Test
    void testAddAuthor() throws SQLException {
        Author author = new Author(0, "Test Author");
        authorDAO.addAuthor(author);

        List<Author> authors = authorDAO.getAllAuthors();
        assertTrue(authors.stream().anyMatch((a -> "Test Author".equals(a.getName()))));
    }
}
