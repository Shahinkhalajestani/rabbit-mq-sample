package com.shahintraining.rabbitmqspringboot.configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:fields.properties", ignoreResourceNotFound = true)
@ConfigurationProperties(prefix = "rabbitmq", ignoreUnknownFields = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RabbitMQFieldsConfig {

    private String queue;
    private String exchange;
    private String routingKey;

}
