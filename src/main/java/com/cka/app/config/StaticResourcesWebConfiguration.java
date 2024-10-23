package com.cka.app.config;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;

@Configuration
@Profile({"prod", "dev"})
public class StaticResourcesWebConfiguration implements WebMvcConfigurer {

    @Value("${cache.timeToLiveInDays:1461}")
    private int timeToLiveInDays = 1461;

    protected static final String[] RESOURCE_LOCATIONS = { "classpath:/static/", "classpath:/static/content/", "classpath:/static/i18n/" };
    protected static final String[] RESOURCE_PATHS = { "/*.js", "/*.css", "/*.svg", "/*.png", "*.ico", "/content/**", "/i18n/*" };

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        ResourceHandlerRegistration resourceHandlerRegistration = appendResourceHandler(registry);
        initializeResourceHandler(resourceHandlerRegistration);
    }

    protected ResourceHandlerRegistration appendResourceHandler(ResourceHandlerRegistry registry) {
        return registry.addResourceHandler(RESOURCE_PATHS);
    }

    protected void initializeResourceHandler(ResourceHandlerRegistration resourceHandlerRegistration) {
        resourceHandlerRegistration.addResourceLocations(RESOURCE_LOCATIONS).setCacheControl(getCacheControl());
    }

    protected CacheControl getCacheControl() {
        return CacheControl.maxAge(getAppHttpCacheProperty(), TimeUnit.DAYS).cachePublic();
    }

    private int getAppHttpCacheProperty() {
        return timeToLiveInDays;
    }

    @Bean
    public MeterRegistry meterRegistry() {
        return new SimpleMeterRegistry();
    }
}
