package br.com.dnl.AppContatos.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class OpenApiConfig {
	@Bean
    public OpenAPI customOpenAPI() {        
        return new OpenAPI()
                .components(new Components().addSecuritySchemes("basicScheme",
                        new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic")))
                .info(new Info()
                        .title("AppContatos")
                        .description("API utilizado para gravar uma pessoa com atributos e contatos")
                        .contact(new Contact().name("Daniel Silva de Almeida").email("daniel.dnlsilva7@gmail.com").url("URL"))
                        .version("Versão API"));
    }
}