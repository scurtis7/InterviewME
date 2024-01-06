package com.scurtis.ime.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "spring.flyway")
public class FlywayProperties {

//    private String url;
//
//    @PostConstruct
//    public void postConstruct() {
//        hasText(url, "spring.flyway.url property must be set");
//    }

}
