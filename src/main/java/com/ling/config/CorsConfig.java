package com.ling.config;

import org.springframework.boot.system.ApplicationHome;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



    //  问题1 跨域
// 问题3 虚拟路径配置   addResourceHandlers（）
@Configuration
public class CorsConfig implements WebMvcConfigurer {

        private CorsConfiguration buildConfig() {
            CorsConfiguration corsConfiguration = new CorsConfiguration();
            corsConfiguration.addAllowedOrigin("*");
            corsConfiguration.addAllowedHeader("*");
            corsConfiguration.addAllowedMethod("*");
            corsConfiguration.addExposedHeader("Authorization");
            return corsConfiguration;
        }

        @Bean
        public CorsFilter corsFilter() {
            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            source.registerCorsConfiguration("/**", buildConfig());
            return new CorsFilter(source);
        }

        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")
                    .allowedOrigins("*")
//          .allowCredentials(true)
                    .allowedMethods("GET", "POST", "DELETE", "PUT")
                    .maxAge(3600);
        }


        // 图片访问 虚拟路径配置
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
//            ApplicationHome applicationHome = new ApplicationHome(this.getClass());
//            String path =applicationHome.getDir().getParentFile().getParentFile().getAbsolutePath()+"\\src\\main\\resources\\static\\";
//
//            registry.addResourceHandler("/static/**")
//                    .addResourceLocations("file:"+path);

            //获取文件的真实路径 work_project代表项目工程名 需要更改
            String path = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\images\\";
            String os = System.getProperty("os.name");
            if (os.toLowerCase().startsWith("win")) {
                registry.addResourceHandler("/images/**").
                        addResourceLocations("file:" + path);
            } else {//linux和mac系统 可以根据逻辑再做处理
                registry.addResourceHandler("/images/**").
                        addResourceLocations("file:" + path);
            }
            WebMvcConfigurer.super.addResourceHandlers(registry);

        }





}
