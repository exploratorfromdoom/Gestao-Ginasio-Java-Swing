package com.example.ginario;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner run(JdbcTemplate jdbcTemplate) {
        return args -> {

            // ✅ SQL query in the SAME FILE
            String sql = """
                SELECT *
                FROM Cliente
            """;

            List<Map<String, Object>> results = jdbcTemplate.queryForList(sql);

            System.out.println("=== QUERY RESULTS ===");

            for (Map<String, Object> row : results) {
                System.out.println(row);
            }
        };
    }
}