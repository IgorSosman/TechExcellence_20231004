package ch.sosman.bookstore.domain.catalog.application.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class BookDto {
  private final String title;
  private final List<String> authors;

  private final String isbn;

  public BookDto(
      @JsonProperty("title") final String title,
      @JsonProperty("authors") final List<String> authors,
      @JsonProperty("isbn") final String isbn) {
    this.title = title;
    this.authors = authors;
    this.isbn = isbn;
  }

  public String getTitle() {
    return title;
  }

  public List<String> getAuthors() {
    return authors;
  }

  public String getIsbn() {
    return isbn;
  }
}
