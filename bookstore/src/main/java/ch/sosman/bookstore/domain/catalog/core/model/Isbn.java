package ch.sosman.bookstore.domain.catalog.core.model;

import ch.sosman.bookstore.domain.catalog.core.model.exception.InvalidIsbnFormatException;
import java.util.regex.Pattern;

public class Isbn {

  private static final Pattern VALID_ISBN_PATTERN;

  private static final String ISBN = "^(?=(?:\\D*\\d){10}(?:(?:\\D*\\d){3})?$)[\\d-]+$";

  static {
    VALID_ISBN_PATTERN = Pattern.compile(ISBN);
  }

  private final String number;

  private Isbn(final String number) {
    this.number = number;
  }

  public String getNumber() {
    return number;
  }

  public interface WithIsbnNumber {
    Builder withIsbnNumber(final String isbnNumber) throws InvalidIsbnFormatException;
  }

  public interface Builder {
    Isbn build();
  }

  public static final class IsbnBuilder implements WithIsbnNumber, Builder {
    private IsbnBuilder() {}

    public static WithIsbnNumber builderInstance() {
      return new IsbnBuilder();
    }

    private String isbnNumber;

    @Override
    public Isbn build() {
      return new Isbn(isbnNumber);
    }

    @Override
    public Builder withIsbnNumber(final String isbnNumber) throws InvalidIsbnFormatException {
      guard(isbnNumber);
      this.isbnNumber = isbnNumber;
      return this;
    }

    private void guard(final String isbnNumber) throws InvalidIsbnFormatException {
      if (isbnNumber == null || isbnNumber.isEmpty() || isbnNumber.isBlank()) {
        throw new InvalidIsbnFormatException();
      }
      if (!VALID_ISBN_PATTERN.matcher(isbnNumber).find()) {
        throw new InvalidIsbnFormatException();
      }
    }
  }
}
