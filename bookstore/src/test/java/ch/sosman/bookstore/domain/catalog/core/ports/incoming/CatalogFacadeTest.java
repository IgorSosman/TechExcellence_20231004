package ch.sosman.bookstore.domain.catalog.core.ports.incoming;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

import ch.sosman.bookstore.domain.catalog.core.model.Author;
import ch.sosman.bookstore.domain.catalog.core.model.Book;
import ch.sosman.bookstore.domain.catalog.core.model.Isbn;
import ch.sosman.bookstore.domain.catalog.core.ports.outgoing.BookRepository;
import java.util.Collections;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CatalogFacadeTest {

  public static final String BOOK_TITLE = "The DDD book";

  @Test
  void displayAll_when_bookInRepository_then_books() {
    // arrange
    final BookRepository repository = Mockito.mock(BookRepository.class);
    doReturn(createBooks()).when(repository).fetchAll();
    final Catalog catalog = new CatalogFacade(repository);
    // act
    final Set<Book> books = catalog.displayAll();
    // assert
    assertNotNull(books);
    assertFalse(books.isEmpty());
    books.forEach(book -> assertEquals(BOOK_TITLE, book.title()));
  }

  @Test
  void displayAll_when_noBooksInRepository_then_emptySet() {
    // arrange
    final BookRepository repository = Mockito.mock(BookRepository.class);
    doReturn(Collections.EMPTY_SET).when(repository).fetchAll();
    final Catalog catalog = new CatalogFacade(repository);
    // act
    final Set<Book> books = catalog.displayAll();
    // assert
    assertNotNull(books);
    assertTrue(books.isEmpty());
  }

  private Set<Book> createBooks() {
    return Set.of(new Book(Set.of(new Author("John Smith")), BOOK_TITLE, new Isbn("isbn")));
  }
}
