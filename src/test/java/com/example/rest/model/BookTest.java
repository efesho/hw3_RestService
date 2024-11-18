package com.example.rest.model;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void testConstructorAndGetters() {
        Date date = new Date(2024,11,11);
        Book book = new Book(1, "Effective Java", date);

        assertEquals(1, book.getId());
        assertEquals("Effective Java", book.getTitle());
        assertEquals(date, book.getPublishedDate());
    }

    @Test
    void testSetters() {
        Book book = new Book();
        Date date = new Date();
        book.setId(2);
        book.setTitle("Clean Code");
        book.setPublishedDate(date);

        assertEquals(2, book.getId());
        assertEquals("Clean Code", book.getTitle());
        assertEquals(date, book.getPublishedDate());
    }

    @Test
    void testEqualsAndHashCode() {
        Date date = new Date();
        Book book1 = new Book(1, "Effective Java", date);
        Book book2 = new Book(1, "Effective Java", date);

        assertEquals(book1, book2);
        assertEquals(book1.hashCode(), book2.hashCode());
    }

    @Test
    void testToString() {
        Date date = new Date();
        Book book = new Book(1, "Effective Java", date);
        String expected = "Book{id=1, title='Effective Java', publishedDate=" + date + "}";

        assertEquals(expected, book.toString());
    }
}
