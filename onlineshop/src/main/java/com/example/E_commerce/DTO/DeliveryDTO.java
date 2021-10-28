package com.example.E_commerce.DTO;

import lombok.Data;
import java.util.Date;

@Data
public class DeliveryDTO {
    private Long deliveryId;
    private String location;
    private Date deliveryDate;
    private Long orderId;
}
