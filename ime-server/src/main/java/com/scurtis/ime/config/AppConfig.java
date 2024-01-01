package com.scurtis.ime.config;

import javax.sql.DataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public DataSource dataSource(PostgresJdbc jdbcProperties) {
        return DataSourceBuilder.create()
            .driverClassName(jdbcProperties.getDriverClassName())
            .url(jdbcProperties.getUrl())
            .username(jdbcProperties.getUsername())
            .password(jdbcProperties.getPassword())
            .build();
    }

}
