package br.com.letscode.javaserverpage.service;

import br.com.letscode.javaserverpage.model.Book;
import java.util.Collection;

public interface BookService {

    Collection<Book> getBooks();

    Book addBook(Book book);
}
