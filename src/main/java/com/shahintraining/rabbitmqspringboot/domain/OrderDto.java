package com.shahintraining.rabbitmqspringboot.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private String orderId;
    private String name;
    private Integer qty;
    private Double price;

}
