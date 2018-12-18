package com.xjtu.config;

import com.xjtu.component.LoginHandlerInterceptor;
import com.xjtu.component.MyLocaleResolver;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

//@EnableWebMvc  //全面接管SpringMVC  SpringBoot对SpringMVC的自动配置不需要了，所有都是我们自己配置；所有的SpringMVC的自动配置都失效了
////SpringBoot2.X版本需要调用WebMvcConfigurer接口实现配置类使用，拦截器下需要将自定义的拦截器类进行容器组件添加
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    //Ctrl+O
    //自定义拦截器
    @Bean
    LoginHandlerInterceptor loginHandlerInterceptor() {
        return new LoginHandlerInterceptor();
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/asserts/**").addResourceLocations("classpath:/static/asserts/");
    }


//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        //添加登录处理拦截器，拦截所有请求，登录请求除外
//        InterceptorRegistration interceptorRegistration = registry.addInterceptor(loginHandlerInterceptor());
//        //排除配置
//        //interceptorRegistration.excludePathPatterns("/sys/login.json");
//        //interceptorRegistration.excludePathPatterns("/charts/**");
//        interceptorRegistration.excludePathPatterns("/asserts/css/**");
//        //interceptorRegistration.excludePathPatterns("/easyUi/**");
//        //interceptorRegistration.excludePathPatterns("/flashPlayer/**");
//        //interceptorRegistration.excludePathPatterns("/font/**");
//        interceptorRegistration.excludePathPatterns("/asserts/img/**");
//        interceptorRegistration.excludePathPatterns("/asserts/js/**");
//        //interceptorRegistration.excludePathPatterns("/pages/**");
//        //interceptorRegistration.excludePathPatterns("/plugin/**");
//        //interceptorRegistration.excludePathPatterns("/index.html");
//        //interceptorRegistration.excludePathPatterns("/show.html");
//        interceptorRegistration.excludePathPatterns("/index.html","/","/user/login");
//        //配置拦截策略
//        interceptorRegistration.addPathPatterns("/**");
//    }

    //1.*版本的用法  SpringBoot2.*不支持
    //所有的webMvcConfigurerAdapter组件都会一起七作用
//    @Bean //将组件注册到容器
//    public WebMvcConfigurationSupport webMvcConfigurationSupport() {
//        WebMvcConfigurationSupport webMvcConfigurationSupport = new WebMvcConfigurationSupport() {
//            @Override
//            public void addResourceHandlers(ResourceHandlerRegistry registry) {
//                registry.addResourceHandler("/static/asserts/**").addResourceLocations("classpath:/static/asserts/");
//            }
//
//            @Override
//            public void addViewControllers(ViewControllerRegistry registry) {
//                registry.addViewController("/").setViewName("login");
//                registry.addViewController("/index.html").setViewName("login");
//                registry.addViewController("/main.html").setViewName("dashboard");
//            }
//
//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
//                //SpringBoot已经做好了对静态资源的映射
//                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html", "/", "/user/login");
//            }
//        };
//        return webMvcConfigurationSupport;
//    }
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }




}
