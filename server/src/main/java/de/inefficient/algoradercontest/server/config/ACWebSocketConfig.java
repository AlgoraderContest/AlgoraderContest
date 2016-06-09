package de.inefficient.algoradercontest.server.config;

import de.inefficient.algoradercontest.server.config.management.ACHttpSessionHandshakeInterceptor;
import de.inefficient.algoradercontest.server.config.management.ACSessionArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.invocation.HandlerMethodArgumentResolver;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.session.ExpiringSession;
import org.springframework.session.web.socket.config.annotation.AbstractSessionWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

import java.util.List;

/**
 * Created by samuel on 09.02.16.
 * @author samuel
 * @version 0.1
 */
@Configuration
@EnableScheduling
@EnableWebSocketMessageBroker
public class ACWebSocketConfig extends AbstractSessionWebSocketMessageBrokerConfigurer<ExpiringSession> {
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
//        config.enableSimpleBroker("/user");
//        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void configureStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/connect").addInterceptors(new ACHttpSessionHandshakeInterceptor()).withSockJS();
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new ACSessionArgumentResolver());
    }
}