package com.example.E_commerce.DTO;

import lombok.Data;

@Data
public class PaymentDTO {
    private String paymentType;
    private int isActive;
    private int isDelete;
}
