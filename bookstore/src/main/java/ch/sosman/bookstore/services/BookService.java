package ch.sosman.bookstore.services;

import ch.sosman.bookstore.controllers.BookDto;
import ch.sosman.bookstore.repository.BooksRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BookService {

  private final BooksRepository booksRepository;

  public BookService(final BooksRepository booksRepository) {
    this.booksRepository = booksRepository;
  }

  public List<BookDto> fetchAllBook() {
    return booksRepository.listAll();
  }
}
