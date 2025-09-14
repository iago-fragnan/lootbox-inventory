package dev.iagof.lootbox.middlewares;

import dev.iagof.lootbox.interceptors.authenticationInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new authenticationInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/users/create")
                .excludePathPatterns("/users/authenticate")
                .excludePathPatterns("/users/validate");
    }

}
