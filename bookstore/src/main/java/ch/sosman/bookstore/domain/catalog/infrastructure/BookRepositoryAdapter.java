package ch.sosman.bookstore.domain.catalog.infrastructure;

import ch.sosman.bookstore.domain.catalog.core.model.Book;
import ch.sosman.bookstore.domain.catalog.core.model.Isbn;
import ch.sosman.bookstore.domain.catalog.core.ports.outgoing.BookRepository;
import java.util.Optional;
import java.util.Set;
import org.springframework.stereotype.Component;

@Component
public class BookRepositoryAdapter implements BookRepository {
  @Override
  public Set<Book> fetchAll() {
    throw new UnsupportedOperationException();
  }

  @Override
  public Optional<Book> fetchByIsbn(final Isbn isbn) {
    throw new UnsupportedOperationException();
  }
}
