package com.springreactive.client;

import com.springreactive.model.Book;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class Client {

    private WebClient client = WebClient.create("http://localhost:8082");

    Mono<Book> getBookDetails(String id){
        return client.get()
                .uri("/movie?id={id}", id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Book.class);
    }
}
