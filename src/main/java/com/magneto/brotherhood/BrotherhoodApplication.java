package com.magneto.brotherhood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@SpringBootApplication
@ComponentScan
public class BrotherhoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrotherhoodApplication.class, args);
	}

}
