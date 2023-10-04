package ch.sosman.bookstore.domain.catalog.infrastructure.model;

import ch.sosman.bookstore.domain.catalog.core.model.Author;
import ch.sosman.bookstore.domain.catalog.core.model.Book;
import ch.sosman.bookstore.domain.catalog.core.model.Isbn;
import java.util.Set;
import org.springframework.stereotype.Component;

@Component
public class BookEntityMapper {
  public Book from(final BookPo bookPo) {
    return new Book(
        Set.of(new Author(bookPo.getAuthor())), bookPo.getTitle(), new Isbn(bookPo.getIsbn()));
  }
}
