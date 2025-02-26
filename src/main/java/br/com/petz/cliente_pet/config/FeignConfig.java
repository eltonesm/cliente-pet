package br.com.petz.cliente_pet.config;

import feign.Request;
import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@EnableFeignClients(basePackages = "br.com.petz.cliente_pet.comunicacao.infra.comunicacao")
@PropertySource("classpath:application.properties")
public class FeignConfig {

    @Value("${feign.connectTimeout:30000}")
    private int connectTimeout;

    @Value("${feign.readTimeout:300000}")
    private int readTimeout;

    @Value("${zapi.client-token}")
    private String clientToken;

    @Bean
    public Request.Options options() {
        return new Request.Options(connectTimeout, readTimeout);
    }

    @Bean
    public RequestInterceptor contentTypeInterceptor() {
        return template -> {
            template.header("Content-Type", "application/json");
            template.header("Client-Token", clientToken); // Adiciona o token de segurança
        };
    }

    @Bean
    public FeignErrorDecoder errorDecoder() {
        return new FeignErrorDecoder();
    }
}
