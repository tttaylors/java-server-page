package br.com.letscode.javaserverpage.service;

import br.com.letscode.javaserverpage.model.Book;
import java.util.List;

public interface BookService {

    List<Book> findAll();

    Book findById(Long id);

    void save(Book book);

    void update(Long id, Book book);

    void deleteById(Long id);
}
