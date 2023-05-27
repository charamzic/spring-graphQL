package cz.javajitsu.springgraphql.controller;

import cz.javajitsu.springgraphql.model.Author;
import cz.javajitsu.springgraphql.repo.AuthorRepo;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class AuthorController {

    private final AuthorRepo authorRepo;

    public AuthorController(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    @QueryMapping
    Iterable<Author> authors() {
        return authorRepo.findAll();
    }

    @QueryMapping
    Optional<Author> authorById(@Argument Long id) {
        return authorRepo.findById(id);
    }
}
