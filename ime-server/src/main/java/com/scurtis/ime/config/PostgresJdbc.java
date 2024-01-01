package com.scurtis.ime.config;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import static org.springframework.util.Assert.hasText;

/**
 * This class is used to set the Datasource which is used by Flyway to create and update the database.
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class PostgresJdbc {

    private String url;
    private String username;
    private String password;
    private String driverClassName;

    @PostConstruct
    public void postConstruct() {
        hasText(url, "spring.datasource.url property must be set");
        hasText(username, "spring.datasource.username property must be set");
        hasText(password, "spring.datasource.password property must be set");
        hasText(driverClassName, "spring.datasource.driver-class-name property must be set");
    }

}
