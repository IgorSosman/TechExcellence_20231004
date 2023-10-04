package ch.sosman.bookstore.domain.catalogue.core;

import java.util.Set;

public record Book(Set<String> authors, String title, String isbn) {}
