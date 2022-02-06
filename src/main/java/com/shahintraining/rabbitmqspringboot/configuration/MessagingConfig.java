package com.shahintraining.rabbitmqspringboot.configuration;

import com.shahintraining.rabbitmqspringboot.domain.OrderDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MessagingConfig {

    private final RabbitMQFieldsConfig rabbitMQFieldsConfig;

    @Bean
    public Queue queue(){
        return new Queue(rabbitMQFieldsConfig.getQueue());
    }

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(rabbitMQFieldsConfig.getExchange());
    }

    @Bean
    public Binding binding(Queue queue,TopicExchange topicExchange){
        return BindingBuilder.bind(queue).to(topicExchange).with(rabbitMQFieldsConfig.getRoutingKey());
    }

    @Bean
    public MessageConverter converter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory){
        final RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(converter());
        return template;
    }


}
