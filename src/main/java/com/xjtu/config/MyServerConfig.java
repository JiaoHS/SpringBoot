package com.xjtu.config;

import com.xjtu.filter.MyFilter;
import com.xjtu.listener.MyListener;
import com.xjtu.servlet.MyServlet;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class MyServerConfig {
    //注册三大组件
    //ServletRegistrationBean
    @Bean
    public ServletRegistrationBean myServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new
                MyServlet(), "/servlet");
        return servletRegistrationBean;
    }

    //FilterRegistrationBean
    @Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/hello","/myServlet"));
        return filterRegistrationBean;
    }
    //ServletListenerRegistrationBean
    @Bean
    public ServletListenerRegistrationBean myListener(){
        ServletListenerRegistrationBean<MyListener> registrationBean = new
                ServletListenerRegistrationBean<>(new MyListener());
        return registrationBean;
    }
    //编写一个EmbeddedServletContainerCustomizer;嵌入式的Servlet容器的定制器；来修改Servlet的容器配置  EmbeddedServletContainerCustomizer已废弃 WebServerFactoryCustomizer替代
    //    @Bean
//    public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer(){
//        return new EmbeddedServletContainerCustomizer() {
//            //定制嵌入式Servlet的容器相关规则
//            @Override
//            public void customize(ConfigurableEmbeddedServletContainer container) {
//                container.setPort(8999);
//            }
//        };
//    }
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer() {
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
            @Override
            public void customize(ConfigurableWebServerFactory factory) {
                factory.setPort(8077);

            }
        };
    }
}
