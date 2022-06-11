package com.ling.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedOrigins("*" +
                        "")
                .allowedMethods("POST","GET","PUT","DELETE")
                .allowCredentials(true)
                .allowedHeaders("*")
                .maxAge(3600);
    }


}
