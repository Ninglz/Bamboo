package com.ninglz.bamboo.commoon.knife.config;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import com.ninglz.bamboo.commoon.knife.support.KnifeProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @program: bamboo
 * @description: knife自动配置，knife 基于swagger2 增强，
 * 配置knife 实际就是配置 swagger2
 * @author: ninglz
 * @created: 2021/07/23 15:02
 */
@Configuration
@ConditionalOnProperty(name = "knife.enabled", matchIfMissing = true)
@RequiredArgsConstructor
public class KnifeAutoConfiguration {

    /**
     * api接口包扫描路径
     */
    public static final String SWAGGER_SCAN_BASE_PACKAGE = "/**";

    /**
     * 排除Spring Boot默认的错误处理路径和端点
     */
    private static final List<String> SWAGGER_DEFAULT_EXCLUDE_PATH = Arrays.asList("/error", "/actuator/**");

    private final KnifeProperties properties;


    @Bean
    public Docket createRestApi() {
        if(ArrayUtil.isEmpty(properties.getBasePath())) {
            properties.getBasePath().add(SWAGGER_SCAN_BASE_PACKAGE);
        }
        if(ArrayUtil.isEmpty(properties.getExcludePath())) {
            properties.getExcludePath().addAll(SWAGGER_DEFAULT_EXCLUDE_PATH);
        }
        // 版本请求头添加version处理用于灰度路由
        List<Parameter> pars = new ArrayList<>();
        Parameter versionPar = new ParameterBuilder().description("灰度路由版本信息")
                .name("VERSION").parameterType("header")
                .modelRef(new ModelRef("string")).required(false)
                .build();
        pars.add(versionPar);

        ApiSelectorBuilder builder = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .globalOperationParameters(pars)
                .select()
                .apis(RequestHandlerSelectors.basePackage(properties.getBasePackage()))
                // 可以根据url路径设置哪些请求加入文档，忽略哪些请求
                .paths(PathSelectors.any());
        properties.getBasePath().forEach(p -> builder.paths(PathSelectors.ant(p)));
        properties.getExcludePath().forEach(p -> builder.paths(PathSelectors.ant(p).negate()));

        return builder.build().securitySchemes(Collections.singletonList(securitySchema()))
                .securityContexts(Collections.singletonList(securityContext())).pathMapping("/");

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 设置文档的标题
                .title(properties.getTitle())
                // 设置文档的描述
                .description(properties.getDescription())
                // 设置文档的版本信息-> 1.0.0 Version information
                .version(properties.getVersion())
                // 设置文档的License信息->1.3 License information
                .termsOfServiceUrl(properties.getTermsOfServiceUrl())
                // 许可证信息
                .license(properties.getLicense())
                // 人员的联系信息
                .contact(new Contact(
                                properties.getContact().getName(),
                                properties.getContact().getUrl(),
                                properties.getContact().getEmail()
                        )
                )
                .build();
    }

    private OAuth securitySchema() {
        ArrayList<AuthorizationScope> authorizationScopeList = new ArrayList<>();
        properties.getAuthorization().getAuthorizationScopeList()
                .forEach(scope -> authorizationScopeList.add(
                        new AuthorizationScope(scope.getScope(), scope.getDescription())));
        ArrayList<GrantType> grantTypes = new ArrayList<>();
        properties.getAuthorization().getTokenUrlList()
                .forEach(tokenUrl -> grantTypes.add(new ResourceOwnerPasswordCredentialsGrant(tokenUrl)));
        return new OAuth(properties.getAuthorization().getName(), authorizationScopeList, grantTypes);
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(defaultAuth()).build();
    }

    private List<SecurityReference> defaultAuth() {
        ArrayList<AuthorizationScope> authorizationScopeList = new ArrayList<>();
        properties.getAuthorization().getAuthorizationScopeList()
                .forEach(scope ->
                        authorizationScopeList.add(
                            new AuthorizationScope(scope.getScope(), scope.getDescription())
                        )
                );
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[authorizationScopeList.size()];
        return Collections.singletonList(SecurityReference.builder().reference(properties.getAuthorization().getName())
                        .scopes(authorizationScopeList.toArray(authorizationScopes)).build());
    }
}

