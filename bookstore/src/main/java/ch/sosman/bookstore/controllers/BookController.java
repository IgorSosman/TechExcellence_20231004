package ch.sosman.bookstore.controllers;

import ch.sosman.bookstore.services.BookService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

  private static final Logger logger = LoggerFactory.getLogger(BookController.class);

  private final BookService bookService;

  public BookController(final BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping("/books")
  public ResponseEntity<List<BookDto>> books() {
    logger.info("Get Books en");
    return ResponseEntity.ok(bookService.fetchAllBook());
  }
}
