package com.shahintraining.rabbitmqspringboot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderStatusDto {

    private OrderDto orderDto;
    private String status;
    private String message;

}
