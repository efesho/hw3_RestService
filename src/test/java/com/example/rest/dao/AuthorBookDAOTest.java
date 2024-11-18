package com.example.rest.dao;

import com.example.rest.model.AuthorBook;
import org.junit.jupiter.api.*;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AuthorBookDAOTest {
    private final AuthorBookDAO authorBookDAO = new AuthorBookDAO();

    @Test
    void testAddAndRetrieveAuthorBook() throws SQLException {
        AuthorBook authorBook = new AuthorBook(1, 1);
        authorBookDAO.addAuthorBook(authorBook);

        List<AuthorBook> authorBooks = authorBookDAO.getAuthorBooksByAuthorId(1);
        assertTrue(authorBooks.stream().anyMatch(ab -> ab.getBookId() == 1));
    }

    @Test
    void testDeleteAuthorBook() throws SQLException {
        AuthorBook authorBook = new AuthorBook(1, 2);
        authorBookDAO.addAuthorBook(authorBook);

        authorBookDAO.deleteAuthorBook(1, 2);

        List<AuthorBook> authorBooks = authorBookDAO.getAuthorBooksByAuthorId(1);
        assertFalse(authorBooks.stream().anyMatch(ab -> ab.getBookId() == 2));
    }
}
