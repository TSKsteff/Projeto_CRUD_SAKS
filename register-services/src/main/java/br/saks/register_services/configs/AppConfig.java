package br.saks.register_services.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
    public String appTitle() {
        return "valor específico";
    }
}
