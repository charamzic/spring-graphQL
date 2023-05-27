package cz.javajitsu.springgraphql.repo;

import cz.javajitsu.springgraphql.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author, Long> {
}
