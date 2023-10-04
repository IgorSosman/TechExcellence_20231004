package ch.sosman.bookstore.application.config;

import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {
  @Override
  public void customize(final ConfigurableServletWebServerFactory factory) {
    factory.setPort(8080);
  }
}
