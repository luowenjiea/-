package com;

import com.config.WebMvcConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@SpringBootApplication
@ServletComponentScan
@MapperScan("com.mapper")
public class MusicApplication {

    public static void main(String[] args) {
        SpringApplication.run(MusicApplication.class, args);
    }

    @Bean
    public WebMvcConfig corsConfigurer(){
       return new WebMvcConfig(){

           @Override
           public void addCorsMappings(CorsRegistry registry) {
               registry.addMapping("/**").allowCredentials(true).allowedOriginPatterns("*");
           }
       };
    }
}

