package de.sperker.websocket.conversational;

import de.sperker.websocket.conversational.server.WebsocketEndpoint;
import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.shell.jline.PromptProvider;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@ConditionalOnWebApplication
@Configuration
public class ApplicationConfig {

    @Value("${spring.profiles.active:}")
    private String activeProfile;

    @Bean
    public PromptProvider myPromptProvider() {
        return () -> new AttributedString("", AttributedStyle.DEFAULT.foreground(AttributedStyle.YELLOW));
    }

    @Bean
    public WebsocketEndpoint echoEndpoint() {
        getActiveProfiles();
        return new WebsocketEndpoint();
    }

    public void getActiveProfiles() {
        System.out.println("Currently active profile - " + activeProfile);
    }

    @Bean
    public ServerEndpointExporter endpointExporter() {
        return new ServerEndpointExporter();
    }

    @Bean
    public CustomSpringConfigurator customSpringConfigurator() {
        return new CustomSpringConfigurator();
    }
}