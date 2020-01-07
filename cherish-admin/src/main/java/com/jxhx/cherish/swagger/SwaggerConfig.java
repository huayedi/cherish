package com.jxhx.cherish.swagger;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * swagger配置
 * @author: 张韶杰
 * @date: 2020/1/7 19:50
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts())
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jxhx"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                .description("更多Spring Boot相关文章请关注：http://jxhxblog.com/")
                .termsOfServiceUrl("http://jxhxblog.com/")
                .contact("今昔何昔")
                .version("1.0")
                .build();
    }

    /**
     * swagger加入全局header 将在ui界面右上角新增token输入界面
     * @return
     */
    private List<ApiKey> securitySchemes() {
        ApiKey apiKey = new ApiKey("token", "token", "header");
        ArrayList arrayList = new ArrayList();
        arrayList.add(apiKey);
        return arrayList;
    }

    /**
     * 在Swagger2的securityContexts中通过正则表达式，设置需要使用参数的接口（或者说，是去除掉不需要使用参数的接口），
     * 如下列代码所示，通过PathSelectors.regex("^(?!auth).*$")，
     * 所有包含"auth"的接口不需要使用securitySchemes。即不需要使用上文中设置的名为“Authorization”，
     * type为“header”的参数。
     *
     */
    private List<SecurityContext> securityContexts() {
        SecurityContext build = SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.any())
                .build();
        ArrayList arrayList = new ArrayList();
        arrayList.add(build);
        return arrayList;
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        SecurityReference authorization = new SecurityReference("token", authorizationScopes);
        ArrayList arrayList = new ArrayList<>();
        arrayList.add(authorization);
        return arrayList;
    }

}
