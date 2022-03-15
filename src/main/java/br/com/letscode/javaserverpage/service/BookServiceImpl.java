package br.com.letscode.javaserverpage.service;

import br.com.letscode.javaserverpage.controller.exception.BookNotFoundException;
import br.com.letscode.javaserverpage.controller.exception.DuplicateBookException;
import br.com.letscode.javaserverpage.repository.BookRepository;
import br.com.letscode.javaserverpage.model.Book;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.Optional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
    }

    @Override
    public void save(Book bookRequest) {
        Optional<Book> bookEntity = bookRepository.findByIsbn(bookRequest.getIsbn());
        if(bookEntity.isPresent()) {
            throw new DuplicateBookException(bookRequest);
        }
        bookRepository.save(bookRequest);
    }

    @Override
    public void update(Long id, Book bookRequest) {
        Book bookEntity = findById(id);
        bookEntity.setAuthor(bookRequest.getAuthor());
        bookEntity.setIsbn(bookRequest.getIsbn());
        bookEntity.setName(bookRequest.getName());
        bookRepository.save(bookEntity);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
