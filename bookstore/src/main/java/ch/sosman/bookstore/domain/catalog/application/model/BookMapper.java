package ch.sosman.bookstore.domain.catalog.application.model;

import ch.sosman.bookstore.domain.catalog.core.model.Author;
import ch.sosman.bookstore.domain.catalog.core.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
  public BookDto from(final Book book) {
    return new BookDto(
        book.title(), book.authors().stream().map(Author::name).toList(), book.isbn().getNumber());
  }
}
