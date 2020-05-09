package com.example.weibiansanjueserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author zhangxu
 * @title
 * @date 2020/3/9 11:55
 */

@Configuration
@EnableSwagger2  //开启swagger
public class SwaggerConfig {

    //配置swagger的Docket的bean实例
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo());
    }

    //配置swagger信息
    private ApiInfo apiInfo(){
        Contact contact=new Contact("", "", "");

        return new ApiInfo("韦编三绝Api",
                "韦编三绝Api文档",
                "1.0",
                "",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
