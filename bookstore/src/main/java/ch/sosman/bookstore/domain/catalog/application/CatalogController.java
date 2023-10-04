package ch.sosman.bookstore.domain.catalog.application;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import ch.sosman.bookstore.domain.catalog.application.model.BookDto;
import ch.sosman.bookstore.domain.catalog.core.model.Isbn;
import ch.sosman.bookstore.domain.catalog.core.model.exception.BookNotFoundException;
import ch.sosman.bookstore.domain.catalog.core.model.exception.InvalidIsbnFormatException;
import ch.sosman.bookstore.domain.catalog.core.ports.incoming.Catalog;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class CatalogController {

  private final Catalog catalog;
  private final CatalogPresenter catalogPresenter;

  public CatalogController(final Catalog catalog, final CatalogPresenter catalogPresenter) {
    this.catalog = catalog;
    this.catalogPresenter = catalogPresenter;
  }

  @GetMapping(produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<List<BookDto>> listAllBook() {
    return catalogPresenter.presentBooks(catalog.displayAll());
  }

  @GetMapping(value = "/{isbn}", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<BookDto> findBookByIsbn(@PathVariable("isbn") final String isbn) {
    try {
      return catalogPresenter.presentBook(
          catalog.findByIsbn(Isbn.IsbnBuilder.builderInstance().withIsbnNumber(isbn).build()));
    } catch (final BookNotFoundException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } catch (final InvalidIsbnFormatException e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }
}
