package com.kkh_chth.articles.observability.client.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kkh_chth.articles.observability.client.service.ArticleServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WebConfig {

    @Bean
    WebClient webClient(ObjectMapper objectMapper) {
        return WebClient.builder()
                .baseUrl("http://localhost:8081")
                .build();
    }


    @Bean
    ArticleServer postClient(WebClient webClient) {
        HttpServiceProxyFactory httpServiceProxyFactory =
                HttpServiceProxyFactory.builderFor(WebClientAdapter.create(webClient))
                        .build();
        return httpServiceProxyFactory.createClient(ArticleServer.class);
    }
}