package com.zjut.smartClassroom;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig implements WebMvcConfigurer {

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("奖励券系统 接口清单")
                .description("红包加息券拆分")
                .termsOfServiceUrl("https://localhost:8081/")
                .version("1.0.0")
                .build();
    }


    @Bean
    public Docket createRestApi() {
        //可以控制 哪些符合条件的 接口 对外暴露文档；
        Predicate<RequestHandler> predicate = (input) -> {
            Set<String> patterns = input.getRequestMapping().getPatternsCondition().getPatterns();
            for (String cur : patterns) {
                if (cur.startsWith("/api")) return true;
            }
            return false;
        };

        ResponseMessage responseMesssageSucc = new ResponseMessageBuilder()
                .code(0)
                .message("处理成功")
                .build();
        ResponseMessage responseMesssageFail = new ResponseMessageBuilder()
                .code(-1)
                .message("处理失败")
                .build();
        List<ResponseMessage> list = new ArrayList();
        list.add(responseMesssageSucc);
        list.add(responseMesssageFail);

        Docket build = new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.POST, list)
                .apiInfo(apiInfo())
                .select()
                .apis(predicate)
                .apis(RequestHandlerSelectors.basePackage("com.moon.coupon.service.controller"))
                .paths(PathSelectors.any())
                .build();
        return build;
    }
}