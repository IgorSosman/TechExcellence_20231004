package ch.sosman.bookstore.infrastructure;

import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

@Component
public class DbHealthIndicator extends AbstractHealthIndicator {

  private final DataSource dataSource;

  public DbHealthIndicator(final DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Override
  protected void doHealthCheck(final Health.Builder builder) {
    try {
      dataSource.getConnection();
      builder.up();
    } catch (final SQLException e) {
      builder.down();
    }
  }
}
