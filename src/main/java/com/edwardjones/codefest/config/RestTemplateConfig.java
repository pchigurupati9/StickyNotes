package com.edwardjones.codefest.config;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

/**
 * Configure RestTemplate with timeouts and interceptors.
 */
@Configuration
public class RestTemplateConfig {

    @Value("${http.connect.timeout:3000}")
    private int httpConnectTimeout;

    @Value("${http.read.timeout:15000}")
    private int httpReadTimeout;

    @Value("${http.connection.request.timeout:5000}")
    private int httpConnectionRequestTimeout;

    @Value("${http.client.max.conn.per.route:300}")
    private int httpClientMaxConnPerRoute;

    @Value("${http.client.max.conn.total:400}")
    private int httpClientMaxConnTotal;


    @Bean
    RestTemplateCustomizer rtCustomizer() {
        return restTemplate -> {
            HttpClient httpClient = HttpClientBuilder.create()
                    .setMaxConnPerRoute(httpClientMaxConnPerRoute)
                    .setMaxConnTotal(httpClientMaxConnTotal).disableCookieManagement().build();

            HttpComponentsClientHttpRequestFactory reqFactory = new HttpComponentsClientHttpRequestFactory();
            reqFactory.setConnectTimeout(httpConnectTimeout);
            reqFactory.setReadTimeout(httpReadTimeout);
            reqFactory.setConnectionRequestTimeout(httpConnectionRequestTimeout);
            reqFactory.setHttpClient(httpClient);

            List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();

            restTemplate.setRequestFactory(reqFactory);
            restTemplate.setInterceptors(interceptors);
        };
    }

}
