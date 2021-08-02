package com.springreactive.service;

import com.springreactive.dto.BookDto;
import com.springreactive.model.Book;
import com.springreactive.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookService {
    
    @Autowired
    private BookRepository bookRepository;

    public Flux<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Mono<ResponseEntity<Book>> getBook(String id) {
        return bookRepository.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    public Mono<Book> addBook(BookDto bookDto){
        return bookRepository.save(new Book(bookDto.getName(), bookDto.getGenre(), bookDto.getReleaseDate()));
    }
}
