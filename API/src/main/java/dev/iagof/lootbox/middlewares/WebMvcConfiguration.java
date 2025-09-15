package dev.iagof.lootbox.middlewares;

import dev.iagof.lootbox.interceptors.authenticationInterceptor;
import dev.iagof.lootbox.interceptors.roleInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new authenticationInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/user/create")
                .excludePathPatterns("/user/authenticate")
                .excludePathPatterns("/user/validate");
        registry.addInterceptor(new roleInterceptor())
                .addPathPatterns("/admin/**");
    }

}
