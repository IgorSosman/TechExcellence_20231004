package ch.sosman.bookstore.infrastructure;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
class DbHealthIndicatorTest {

  private DataSource dataSource;

  DbHealthIndicatorTest() {}

  @BeforeEach
  void setup(final TestInfo testInfo) throws SQLException {
    this.dataSource = mock(DataSource.class);
    if (testInfo.getTags().contains("HappyPath")) {
      doReturn(mock(Connection.class)).when(dataSource).getConnection();
    }
    if (testInfo.getTags().contains("SadPath")) {
      doThrow(SQLException.class).when(dataSource).getConnection();
    }
  }

  @Test
  @Tag("HappyPath")
  void doHealthCheck_when_dataSource_then_up() {
    // arrange
    final var healthBuilder = mock(Health.Builder.class);
    final DbHealthIndicator dbHealthIndicator = new DbHealthIndicator(dataSource);
    // act
    dbHealthIndicator.doHealthCheck(healthBuilder);
    // assert
    verify(healthBuilder, times(1)).up();
    verify(healthBuilder, times(0)).down();
  }

  @Test
  @Tag("SadPath")
  void doHealthCheck_when_noDataSource_then_down() {
    // arrange
    final var healthBuilder = mock(Health.Builder.class);
    final DbHealthIndicator dbHealthIndicator = new DbHealthIndicator(dataSource);
    // act
    dbHealthIndicator.doHealthCheck(healthBuilder);
    // assert
    verify(healthBuilder, times(0)).up();
    verify(healthBuilder, times(1)).down();
  }
}
