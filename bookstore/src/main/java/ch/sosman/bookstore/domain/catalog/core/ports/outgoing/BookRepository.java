package ch.sosman.bookstore.domain.catalog.core.ports.outgoing;

import ch.sosman.bookstore.domain.catalog.core.model.Book;
import ch.sosman.bookstore.domain.catalog.core.model.Isbn;
import java.util.Optional;
import java.util.Set;

public interface BookRepository {
  Set<Book> fetchAll();

  Optional<Book> fetchByIsbn(final Isbn isbn);
}
