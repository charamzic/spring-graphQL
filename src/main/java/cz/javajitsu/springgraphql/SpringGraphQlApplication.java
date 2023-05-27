package cz.javajitsu.springgraphql;

import cz.javajitsu.springgraphql.model.Author;
import cz.javajitsu.springgraphql.model.Book;
import cz.javajitsu.springgraphql.repo.AuthorRepo;
import cz.javajitsu.springgraphql.repo.BookRepo;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringGraphQlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringGraphQlApplication.class, args);
    }


    @Bean
    ApplicationRunner applicationRunner(AuthorRepo authorRepo, BookRepo bookRepo) {
        return args -> {
            Author josh = authorRepo.save(new Author(null, "Josh"));
            Author mark = authorRepo.save(new Author(null, "Mark"));
            bookRepo.saveAll(List.of(
                    new Book("Book 1", "Melvin", josh),
                    new Book("Book 2", "Melvin", mark),
                    new Book("Book 3", "Melvin", mark)
            ));
        };
    }
}
