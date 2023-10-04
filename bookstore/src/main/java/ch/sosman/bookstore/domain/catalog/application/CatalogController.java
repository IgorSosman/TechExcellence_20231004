package ch.sosman.bookstore.domain.catalog.application;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import ch.sosman.bookstore.domain.catalog.application.model.BookDto;
import ch.sosman.bookstore.domain.catalog.core.ports.incoming.Catalog;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
}
