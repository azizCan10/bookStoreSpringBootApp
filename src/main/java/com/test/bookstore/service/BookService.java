package com.test.bookstore.service;

import com.test.bookstore.entity.Book;
import com.test.bookstore.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;

    public Optional<Book> getById(Integer id) {
        return bookRepository.findById(id);
    }
}
