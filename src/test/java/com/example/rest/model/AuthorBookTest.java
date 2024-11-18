package com.example.rest.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthorBookTest {

    @Test
    void testConstructorAndGetters() {
        AuthorBook authorBook = new AuthorBook(1, 2);

        assertEquals(1, authorBook.getAuthorId());
        assertEquals(2, authorBook.getBookId());
    }

    @Test
    void testSetters() {
        AuthorBook authorBook = new AuthorBook();
        authorBook.setAuthorId(3);
        authorBook.setBookId(4);

        assertEquals(3, authorBook.getAuthorId());
        assertEquals(4, authorBook.getBookId());
    }

    @Test
    void testEqualsAndHashCode() {
        AuthorBook authorBook1 = new AuthorBook(1, 2);
        AuthorBook authorBook2 = new AuthorBook(1, 2);

        assertEquals(authorBook1, authorBook2);
        assertEquals(authorBook1.hashCode(), authorBook2.hashCode());
    }

    @Test
    void testToString() {
        AuthorBook authorBook = new AuthorBook(1, 2);
        String expected = "AuthorBook{authorId=1, bookId=2}";

        assertEquals(expected, authorBook.toString());
    }
}
