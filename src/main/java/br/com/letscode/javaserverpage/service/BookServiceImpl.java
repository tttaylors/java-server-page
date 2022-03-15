package br.com.letscode.javaserverpage.service;

import br.com.letscode.javaserverpage.exception.DuplicateBookException;
import br.com.letscode.javaserverpage.repository.BookRepository;
import br.com.letscode.javaserverpage.model.Book;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Collection<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book addBook(Book bookRequest) {
        Optional<Book> bookEntity = bookRepository.findByIsbn(bookRequest.getIsbn());
        if(bookEntity.isPresent()) {
            throw new DuplicateBookException(bookRequest);
        }
        return bookRepository.save(bookRequest);
    }
}
