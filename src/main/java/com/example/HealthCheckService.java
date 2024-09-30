package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class HealthCheckService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean isDatabaseHealthy() {
        try {
            jdbcTemplate.execute("SELECT 1");
            System.out.println("Database is healthy");
            return true;  // Connection is healthy
        } catch (Exception e) {
            System.err.println("Database connection failed: " + e.getMessage());
            return false; // Connection failed
        }
    }
}
