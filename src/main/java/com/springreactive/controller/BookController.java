package com.springreactive.controller;

import com.springreactive.dto.BookDto;
import com.springreactive.model.Book;
import com.springreactive.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
public class BookController {
    
    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public Flux<Book> allBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("{id}")
    public Mono<ResponseEntity<Book>> getBook(@PathVariable final String id){
        return bookService.getBook(id);
    }

    @PostMapping("/add")
    public Mono<Book> addBook(@RequestBody BookDto bookDto){
        return bookService.addBook(bookDto);
    }
}
