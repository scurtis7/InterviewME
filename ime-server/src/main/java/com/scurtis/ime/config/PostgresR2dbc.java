package com.scurtis.ime.config;

import jakarta.annotation.PostConstruct;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import static org.springframework.util.Assert.hasText;

/**
 * This class is strictly for verifying that the spring r2dbc properties are set.
 */
@Setter
@Configuration
@ConfigurationProperties(prefix = "spring.r2dbc")
public class PostgresR2dbc {

    private String url;
    private String username;
    private String password;

    @PostConstruct
    public void postConstruct() {
        hasText(url, "spring.r2dbc.url property must be set");
        hasText(username, "spring.r2dbc.username property must be set");
        hasText(password, "spring.r2dbc.password property must be set");
    }

}
