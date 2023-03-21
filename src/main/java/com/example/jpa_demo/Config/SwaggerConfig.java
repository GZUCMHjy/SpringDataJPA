package com.example.jpa_demo.Config;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration//该注解标记为spring管理的配置类文件
@EnableSwagger2//注解对应上的pom.xml配置的依赖swagger2
@EnableSwaggerBootstrapUI
public class SwaggerConfig  {
    //模板swaggerConfig（C/V就完事了）
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("图书管理接口")
                .apiInfo(apiInfo())
                .host("localhost:8080")
                .select()
                //要扫描标记过注解的api接口(Controller)
                .apis(RequestHandlerSelectors.basePackage("com.example.jpa_demo.Controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("JpaTestDemo")
                .description("Test")
                .contact(new Contact("louis", "", ""))//作者
                .termsOfServiceUrl("")
                .version("1.0")
                .build();
    }
}


