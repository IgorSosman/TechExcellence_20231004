package ch.sosman.bookstore.domain.catalog.core.ports.incoming;

import ch.sosman.bookstore.domain.catalog.core.model.Book;
import ch.sosman.bookstore.domain.catalog.core.model.Isbn;
import ch.sosman.bookstore.domain.catalog.core.model.exception.BookNotFoundException;
import ch.sosman.bookstore.domain.catalog.core.ports.outgoing.BookRepository;
import java.util.Set;
import org.springframework.stereotype.Component;

@Component
public class CatalogFacade implements Catalog {
  private final BookRepository bookRepository;

  public CatalogFacade(final BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @Override
  public Set<Book> displayAll() {
    return bookRepository.fetchAll();
  }

  @Override
  public Book findByIsbn(final Isbn isbn) throws BookNotFoundException {
    return bookRepository.fetchByIsbn(isbn).orElseThrow(BookNotFoundException::new);
  }
}
