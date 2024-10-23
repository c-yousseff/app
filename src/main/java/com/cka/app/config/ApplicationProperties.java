package com.cka.app.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Properties specific to Delete.
 * <p>
 * Properties are configured in the {@code application.yml} file.
 */
@Getter
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {

    private final Liquibase liquibase = new Liquibase();


    @Setter
    @Getter
    public static class Liquibase {

        private Boolean asyncStart;

    }
}
