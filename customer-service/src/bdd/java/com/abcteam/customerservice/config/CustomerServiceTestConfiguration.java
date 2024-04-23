package com.abcteam.customerservice.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

@Slf4j
@TestConfiguration
public class CustomerServiceTestConfiguration {

    public static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer("postgres:15")
            .withDatabaseName("test")
            .withUsername("testUser")
            .withPassword("testPassword");


    @DynamicPropertySource
    public static void properties(DynamicPropertyRegistry registry){
        registry.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl);
        registry.add("spring.datasource.username", postgreSQLContainer::getUsername);
        registry.add("spring.datasource.password", postgreSQLContainer::getPassword);
        registry.add("spring.datasource.driverClassName", postgreSQLContainer::getDriverClassName);
    }

    static {
        postgreSQLContainer.start();
        log.info("Test Postgres Container started");
    }
}
