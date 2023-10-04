package ch.sosman.bookstore.domain.catalog.core.ports.outgoing;

import ch.sosman.bookstore.domain.catalog.core.model.Book;
import java.util.Set;

public interface BookRepository {
  Set<Book> fetchAll();
}
