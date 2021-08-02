package com.springreactive;

import com.springreactive.dto.BookDto;
import com.springreactive.model.Book;
import com.springreactive.model.EGenre;
import com.springreactive.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.LocalDateTime;

@SpringBootApplication
public class SpringReactiveWebMongodbApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringReactiveWebMongodbApplication.class);

	@Bean
	CommandLineRunner init(BookService bookService){

		return args -> {

			log.info("--Before--");
			Flux.just("a", "b", "c", "d", "e")
					.take(3)
					.delayElements(Duration.ofMillis(1000))
					.map(String::toUpperCase)
					.doAfterTerminate(() -> log.info("--Done--"))
					.subscribe(log::info);
			log.info("--After--");


			Flux<Book> moviesFlux = Flux.just(
					new BookDto("Spring Boot", EGenre.COMPUTER_SCIENCE, LocalDateTime.now()),
					new BookDto("jAVA", EGenre.COMPUTER_SCIENCE, LocalDateTime.now()),
					new BookDto( "Learn English", EGenre.LANGUAGE, LocalDateTime.now()))
					.flatMap(bookService::addBook);

			moviesFlux.thenMany(bookService.getAllBooks()).subscribe(item -> log.info(String.valueOf(item)));
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringReactiveWebMongodbApplication.class, args);
	}

}
