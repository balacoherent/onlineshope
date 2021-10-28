package com.example.E_commerce.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderDTO {

    private Long orderId;

    private int quantity;

    private Integer totalPrice;

    private Long userId;

    private Long paymentId;

    private List<ProductDTO> productId;
}
