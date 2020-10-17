package com.aaa.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@Component
public class AgeRoutePredicateFactory extends AbstractRoutePredicateFactory<AgeRoutePredicateFactory.Config> {
    public AgeRoutePredicateFactory() {
        super(AgeRoutePredicateFactory.Config.class);
    }
    //读取配置文件中的内容并配置给配置类中的属性
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("minAge","maxAge");
    }

    public Predicate<ServerWebExchange> apply(AgeRoutePredicateFactory.Config config) {
        return (exchange) -> {
            String age = exchange.getRequest().getQueryParams().getFirst("age");
            if(StringUtils.isNotEmpty(age)){
                int a = Integer.parseInt(age);
                return a>=config.minAge && a<=config.maxAge;
            }
            return true;
        };
    }



    @Data
    @NoArgsConstructor
    //@AllArgsConstructor
    public static class Config{
        private Integer minAge;
        private Integer maxAge;
    }
}
