package com.shahintraining.rabbitmqspringboot.configuration;

import com.shahintraining.rabbitmqspringboot.domain.OrderStatusDto;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RabbitConsumer {

    @RabbitListener(queues = "${rabbitmq.queue}")
    public void consumeMessageFromQueue(OrderStatusDto orderStatusDto){
        System.out.println("Message received from the Queue is : "+orderStatusDto);
    }

}
