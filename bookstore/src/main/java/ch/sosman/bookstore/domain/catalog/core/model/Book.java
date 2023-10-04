package ch.sosman.bookstore.domain.catalog.core.model;

import java.util.Set;

public record Book(Set<Author> authors, String title, Isbn isbn) {}
