package cz.javajitsu.springgraphql.controller;

import cz.javajitsu.springgraphql.model.Author;
import cz.javajitsu.springgraphql.model.Book;
import cz.javajitsu.springgraphql.repo.AuthorRepo;
import cz.javajitsu.springgraphql.repo.BookRepo;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

    private final BookRepo bookRepo;
    private final AuthorRepo authorRepo;

    public BookController(BookRepo bookRepo, AuthorRepo authorRepo) {
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
    }

    @MutationMapping
    Book addBook(@Argument BookInput book) {
        Author author = authorRepo.findById(book.authorId()).orElseThrow(() ->
                new IllegalArgumentException("Author not found."));
        Book b = new Book(book.title(), book.publisher(), author);
        return bookRepo.save(b);
    }

    record BookInput(String title, String publisher, Long authorId) {
    }
}
