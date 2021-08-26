package com.cxz.cxzspringboot_web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/8/26 16:02
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("国旅财务接口文档")
                .description("国旅财务数据和操作接口。")
                .version("1.0")
                .build();
    }
}
