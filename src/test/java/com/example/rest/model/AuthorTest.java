package com.example.rest.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthorTest {

    @Test
    void testConstructorAndGetters() {
        Author author = new Author(1, "John Doe");

        assertEquals(1, author.getId());
        assertEquals("John Doe", author.getName());
    }

    @Test
    void testSetters() {
        Author author = new Author();
        author.setId(2);
        author.setName("Jane Smith");

        assertEquals(2, author.getId());
        assertEquals("Jane Smith", author.getName());
    }

    @Test
    void testEqualsAndHashCode() {
        Author author1 = new Author(1, "John Doe");
        Author author2 = new Author(1, "John Doe");

        assertEquals(author1, author2);
        assertEquals(author1.hashCode(), author2.hashCode());
    }

    @Test
    void testToString() {
        Author author = new Author(1, "John Doe");
        String expected = "Author{id=1, name='John Doe'}";

        assertEquals(expected, author.toString());
    }
}
