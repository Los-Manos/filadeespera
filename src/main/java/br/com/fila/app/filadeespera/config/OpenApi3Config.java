package br.com.fila.app.filadeespera.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

/**
 * OpenApi3
 */
@Configuration
@OpenAPIDefinition(info = @Info(
    title = "ms-fila-de-espera-app", 
    description = "Serviço de geração de senha para fila de espera.",
    version = "v1"
))
public class OpenApi3Config {
    
}

