package br.com.ministeriosemar.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
@Configuration
public class SwaggerConfig {
   @Bean
   public OpenAPI customOpenApi() {
       return new OpenAPI()
               .components(new Components())
               .info(new Info()
                       .title("API para Controle de Membros, Ministérios e Grupos de GPS")
                       .description("Projeto desenvolvido com Spring Boot e Spring Data JPA")
                       .version("v1")
                       .contact(new Contact()
                               .name("Douglas Alvares")
                               .email("bydouglascontato@gmail.com")
                               .url("https://www.douglasalvares.com.br"))
                       .license(new License()
                               .name("Licença")
                               .url("https://www.example.com/license")));
   }
}