package wxx.boker.chapter011.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Slf4j
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.info("this is 拦截器  ");
        log.info("this is 拦截器  ");
        log.info("this is 拦截器  ");
//        registry.addInterceptor(new MyInterceptor1()).addPathPatterns("/**").excludePathPatterns("/boot");
        registry.addInterceptor(new MyInterceptor1()).addPathPatterns("/boot");
    }
}
