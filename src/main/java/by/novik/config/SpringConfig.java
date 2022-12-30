package by.novik.config;

import by.novik.interceptor.FirstInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc //по 2-м аннотациям поймет что это паттерн мвс
@ComponentScan("by.novik")
public class SpringConfig implements WebMvcConfigurer { //Web Mvc Config - сойденяет все бины здесь, добавляем когда добавляем interceptor
@Bean
public FirstInterceptor getFirstInterceptor() {
    return new FirstInterceptor();
}

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getFirstInterceptor());
    }
}
