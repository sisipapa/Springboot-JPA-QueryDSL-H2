package com.sisipapa.toy1.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(title = "Posts API 명세서",
                description = "API 명세서",
                version = "v1",
                contact = @Contact(name = "sisipapa", email = "sisipapa239@gmail.com"),
                license = @License(name = "Apache 2.0",
                        url = "http://www.apache.org/licenses/LICENSE-2.0.html")
        )
)
@Configuration
public class OpenApiConfig {
    /**
     * postsOpenApi.
     * @return GroupedOpenApi
     */
    @Bean
    public GroupedOpenApi postsOpenApi() {
        String[] paths = {"/v1/post/**"};
        return GroupedOpenApi.builder().setGroup("Posts관련 API").pathsToMatch(paths)
                .build();
    }
}
