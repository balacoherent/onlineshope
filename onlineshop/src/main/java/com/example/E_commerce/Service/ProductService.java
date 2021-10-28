package com.example.E_commerce.Service;

import com.example.E_commerce.BaseReponse.PageResponse;
import com.example.E_commerce.DTO.ProductDTO;
import com.example.E_commerce.Entity_or_Model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {


    Product deleteProduct(Long productId);

    Product AddProduct(ProductDTO productDTO);

    Optional<Product> UpdateByProductId(ProductDTO productDTO);

    List<Product> ListAll();

    PageResponse<Product> productPagination(int offset, int pageSize, String category);
}
