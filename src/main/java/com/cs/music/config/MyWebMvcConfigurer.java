package com.cs.music.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {


    @Value("${cs.music.file.dir:''}")
    public String fileDir;
    @Value("${cs.music.file.static-access-path:''}")
    public String staticAccessPath;

    /**
     * 配置静态访问资源
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(staticAccessPath).addResourceLocations("file:" + fileDir);
    }
}
