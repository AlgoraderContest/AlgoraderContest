package de.inefficient.algoradercontest.server.config;

import de.inefficient.algoradercontest.server.config.management.ACSessionArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * Created by samuel on 09.02.16.
 * @author samuel
 * @version 0.1
 */
@Configuration
@EnableWebMvc
public class ACWebMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:resources/");
        registry.addResourceHandler("/lib/**").addResourceLocations("classpath:static/");
        registry.addResourceHandler("/views/**").addResourceLocations("classpath:templates/views/");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new ACSessionArgumentResolver());
    }
}