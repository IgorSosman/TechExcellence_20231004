package ch.sosman.bookstore.repository;

import ch.sosman.bookstore.controllers.BookDto;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class BooksRepository {
  public List<BookDto> listAll() {
    return List.of(
        new BookDto(
            "Domain-Driven Design: Tackling Complexity in the Heart of Software",
            "Eric Evans",
            "978-0321125217",
            75.00),
        new BookDto("Implementing Domain-Driven Design", "Vaughn Vernon", "978-0321834577", 69.90),
        new BookDto("Learning Domain-Driven Design", "Vladik Khononov", "978-1098100131", 57.90));
  }
}
