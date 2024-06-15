package dev.igor.redis;

import java.util.HashMap;
import java.util.Map;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    Map<Long, Book> books = new HashMap<>() {
        {
            put(1L, new Book(1L, "O Pequeno Príncipe"));
            put(2L, new Book(2L, "Romeu E Julieta"));
            put(3L, new Book(3L, "1984"));
            put(4L, new Book(4L, "Dom Quixote De La mancha"));
            put(5L, new Book(5L, "Os Miseráveis"));
        }
    };

    @Cacheable("books")
    public Book getById(Long id) {
        System.out.println("Buscando productos");
        simulateLatency();
        return books.get(id);
    }

    private void simulateLatency() {
        try {
            long time = 1000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    } 
}
