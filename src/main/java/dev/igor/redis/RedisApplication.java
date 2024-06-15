package dev.igor.redis;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class RedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisApplication.class, args);
	}

	@Bean
	ApplicationRunner runner(BookService service) {
		return args -> {
			System.out.println("\n\n\n\n\n\n\n\n\n");
			System.out.println("Id 1 " + service.getById(1L));
			System.out.println("Id 2 " + service.getById(2L));
			System.out.println("Id 1 " + service.getById(1L));
			System.out.println("Id 1 " + service.getById(1L));
			System.out.println("Id 1 " + service.getById(1L));
		};
	}
}
