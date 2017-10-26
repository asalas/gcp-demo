package io.swagger;

import javax.cache.configuration.MutableConfiguration;
import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * @author asalas
 */
@Configuration
@EnableCaching
@Profile("production")
public class AppConfig extends WebMvcConfigurerAdapter
{
    @Bean
    public JCacheManagerCustomizer cacheManagerCustomizer()
    {
        return cm ->
        {
            javax.cache.configuration.Configuration<Object, Object> cacheConfiguration = createCacheConfiguration();
            cm.createCache("gcp-cache", cacheConfiguration);
        };
    }

    private javax.cache.configuration.Configuration<Object, Object> createCacheConfiguration()
    {
        // Create a cache using infinite heap. A real application will want to use an
        // implementation dependent configuration that will better fit your needs
        return new MutableConfiguration<>().setStatisticsEnabled(true);
    }
}