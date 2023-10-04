package ch.sosman.bookstore.domain.catalog.application;

import static org.springframework.http.HttpStatus.OK;

import ch.sosman.bookstore.domain.catalog.application.model.BookDto;
import ch.sosman.bookstore.domain.catalog.application.model.BookMapper;
import ch.sosman.bookstore.domain.catalog.core.model.Book;
import java.util.List;
import java.util.Set;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CatalogPresenter {

  private final BookMapper mapper;

  public CatalogPresenter(final BookMapper mapper) {
    this.mapper = mapper;
  }

  public ResponseEntity<List<BookDto>> presentBooks(final Set<Book> books) {
    return new ResponseEntity<>(books.stream().map(mapper::from).toList(), OK);
  }

  public ResponseEntity<BookDto> presentBook(final Book book) {
    return new ResponseEntity<>(mapper.from(book), OK);
  }
}
