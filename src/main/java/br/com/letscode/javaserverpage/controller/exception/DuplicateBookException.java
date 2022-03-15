package br.com.letscode.javaserverpage.controller.exception;

import br.com.letscode.javaserverpage.model.Book;
import lombok.Getter;

@Getter
public class DuplicateBookException extends RuntimeException {

    private final Book book;

    public DuplicateBookException(Book book) {
        this.book = book;
    }
}
