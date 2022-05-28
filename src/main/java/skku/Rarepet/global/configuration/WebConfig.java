package skku.Rarepet.global.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import skku.Rarepet.global.interceptor.LoginInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LoginInterceptor loginInterceptor =  new LoginInterceptor();
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns(loginInterceptor.blackList)
                .excludePathPatterns(loginInterceptor.whiteList);
    }
}
