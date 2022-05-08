package com.comp62542.backend.config;


import com.comp62542.backend.interceptors.AdminRequiredInterceptor;
import com.comp62542.backend.interceptors.JWTInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    private JWTInterceptor jwtInterceptor;

    @Autowired
    private AdminRequiredInterceptor adminRequiredInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/user/login")
                .order(Ordered.HIGHEST_PRECEDENCE);
        registry.addInterceptor(adminRequiredInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/user/login")
                .order(Ordered.LOWEST_PRECEDENCE);
    }
}
