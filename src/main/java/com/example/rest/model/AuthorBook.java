package com.example.rest.model;

import java.util.Objects;

public class AuthorBook {
    private int authorId;
    private int bookId;

    public AuthorBook() {}

    public AuthorBook(int authorId, int bookId) {
        this.authorId = authorId;
        this.bookId = bookId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "AuthorBook{" +
                "authorId=" + authorId +
                ", bookId=" + bookId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorBook that = (AuthorBook) o;
        return authorId == that.authorId && bookId == that.bookId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorId, bookId);
    }
}
