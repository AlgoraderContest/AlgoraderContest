package de.inefficient.algoradercontest.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.PathResource;

import java.io.IOException;

/**
 * Created by samuel on 09.02.16.
 * @author samuel
 * @version 0.1
 */
@Configuration
public class ACSslConfig {
    private static Logger logger = LoggerFactory.getLogger(ACSslConfig.class);

    @Bean
    public TomcatEmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
        factory.setPort(8080);
        try {
            factory.addAdditionalTomcatConnectors(sslConnector());
        } catch (IllegalStateException e) {
            logger.warn("Ssl encryption failed to load!");
        }
        return factory;
    }


    private Connector sslConnector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setScheme("https");
        connector.setSecure(true);
        connector.setPort(8443);
        try {
            Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
            JsonNode config = new ObjectMapper().readTree(new PathResource("ssl.conf").getInputStream());
            protocol.setKeystoreFile(new PathResource(config.get("filename").textValue()).getFile().getAbsolutePath());
            protocol.setKeystorePass(config.get("password").textValue());
            protocol.setKeystoreType("PKCS12");
            protocol.setSSLEnabled(true);
            return connector;
        } catch (IOException ex) {
            throw new IllegalStateException("can't access keystore", ex);
        }
    }
}