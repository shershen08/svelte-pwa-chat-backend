package de.sperker.websocket.conversational;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan
@EnableAutoConfiguration
public class WebsockeDemoApplication {

	public static void main(String[] args) {
		System.out.println("Starting Conversational Websocket Server ...");
		SpringApplication.run(WebsockeDemoApplication.class, args);
		System.exit(0);
	}
}