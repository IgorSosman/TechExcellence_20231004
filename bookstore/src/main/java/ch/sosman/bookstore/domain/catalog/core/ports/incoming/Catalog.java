package ch.sosman.bookstore.domain.catalog.core.ports.incoming;

import ch.sosman.bookstore.domain.catalog.core.model.Book;
import ch.sosman.bookstore.domain.catalog.core.model.Isbn;
import ch.sosman.bookstore.domain.catalog.core.model.exception.BookNotFoundException;
import java.util.Set;

public interface Catalog {
  Set<Book> displayAll();

  Book findByIsbn(final Isbn isbn) throws BookNotFoundException;
}
