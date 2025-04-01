package com.UTSEM.EOG;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ServiciosEscuelaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiciosEscuelaApplication.class, args);
	}
	
	@Bean
	WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://127.0.0.1:4200", "http://localhost:4200")
						.allowedMethods("*").allowedHeaders("*").allowCredentials(true);
			}
		};
	}

}
