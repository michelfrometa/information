package com.information.demo.configuration;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;

@TestConfiguration(proxyBeanMethods = false)
public class TestContainersConfiguration {

    @Bean
    @ServiceConnection(name = "postgresql")
    public PostgreSQLContainer postgreSQLContainer() {
        return new PostgreSQLContainer<>("postgres")
                .withEnv("username", "username")
                .withEnv("password", "password")
                .withExposedPorts(5432)
                .withReuse(true);
    }
}
