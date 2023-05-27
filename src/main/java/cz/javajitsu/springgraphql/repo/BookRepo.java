package cz.javajitsu.springgraphql.repo;

import cz.javajitsu.springgraphql.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Long> {
}
