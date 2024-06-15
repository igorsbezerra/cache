package dev.igor.redis;

import java.io.Serializable;

public record Book(Long id, String description) implements Serializable {
}
