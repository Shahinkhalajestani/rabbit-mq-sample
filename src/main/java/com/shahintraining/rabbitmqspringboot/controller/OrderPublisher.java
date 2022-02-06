package com.shahintraining.rabbitmqspringboot.controller;

import com.rabbitmq.client.impl.recovery.RecordedEntity;
import com.shahintraining.rabbitmqspringboot.configuration.RabbitMQFieldsConfig;
import com.shahintraining.rabbitmqspringboot.domain.OrderDto;
import com.shahintraining.rabbitmqspringboot.domain.OrderStatusDto;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderPublisher {

    private final RabbitTemplate template;
    private final RabbitMQFieldsConfig fieldsConfig;

    @PostMapping("/publish")
    public ResponseEntity<String> bookOrder(@RequestBody OrderDto orderDto) {
        orderDto.setOrderId(UUID.randomUUID().toString());
        OrderStatusDto orderStatusDto = new OrderStatusDto(orderDto, "PROCESS",
                "Order has been put successfully");
        template.convertAndSend(fieldsConfig.getExchange(), fieldsConfig.getRoutingKey(),orderStatusDto);
        return ResponseEntity.ok("success");
    }
}
