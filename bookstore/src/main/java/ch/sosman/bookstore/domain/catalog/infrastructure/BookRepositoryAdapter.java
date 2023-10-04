package ch.sosman.bookstore.domain.catalog.infrastructure;

import ch.sosman.bookstore.domain.catalog.core.model.Book;
import ch.sosman.bookstore.domain.catalog.core.model.Isbn;
import ch.sosman.bookstore.domain.catalog.core.model.exception.InvalidIsbnFormatException;
import ch.sosman.bookstore.domain.catalog.core.ports.outgoing.BookRepository;
import ch.sosman.bookstore.domain.catalog.infrastructure.model.BookEntityMapper;
import ch.sosman.bookstore.domain.catalog.infrastructure.model.BookPo;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

@Component
public class BookRepositoryAdapter implements BookRepository {

  private final BookDatabase database;
  private final BookEntityMapper mapper;

  public BookRepositoryAdapter(final BookDatabase database, final BookEntityMapper mapper) {
    this.database = database;
    this.mapper = mapper;
  }

  @Override
  public Set<Book> fetchAll() {

    return database.findAll().stream()
        .map(
            bookPo -> {
              try {
                return mapper.from(bookPo);
              } catch (final InvalidIsbnFormatException e) {
                throw new RuntimeException(e);
              }
            })
        .collect(Collectors.toUnmodifiableSet());
  }

  @Override
  public Optional<Book> fetchByIsbn(final Isbn isbn) {
    final BookPo example = new BookPo();
    example.setIsbn(isbn.getNumber());
    return database
        .findOne(Example.of(example))
        .map(
            bookPo -> {
              try {
                return mapper.from(bookPo);
              } catch (final InvalidIsbnFormatException e) {
                return null;
              }
            });
  }
}
