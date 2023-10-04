package ch.sosman.bookstore.domain.catalog.infrastructure;

import ch.sosman.bookstore.domain.catalog.infrastructure.model.BookPo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDatabase extends JpaRepository<BookPo, Long> {}
