package com.example.E_commerce.DTO;

import lombok.Data;

@Data
public class ProductDTO {

    public Long productId;
    public String category;
    public String productName;
    public int prize;

    private int isActive;
    private int isDelete;

}
