package com.example.E_commerce.Controller;

import com.example.E_commerce.BaseReponse.BaseResponse;
import com.example.E_commerce.BaseReponse.PageResponse;
import com.example.E_commerce.DTO.ProductDTO;
import com.example.E_commerce.Entity_or_Model.Product;
import com.example.E_commerce.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public BaseResponse<Product> addProduct(@RequestBody ProductDTO productDTO){
        BaseResponse<Product> baseResponse;
        baseResponse = BaseResponse.<Product>builder().data(productService.AddProduct(productDTO)).build();
        return baseResponse;
    }

    @PutMapping("/update")
    public BaseResponse<Optional<Product>> updateByProductId(@RequestBody ProductDTO productDTO){
        BaseResponse<Optional<Product>> baseResponse;
        baseResponse = BaseResponse.<Optional<Product>>builder().data(productService.UpdateByProductId(productDTO)).build();
        return  baseResponse;
    }

    @GetMapping("/getAll")
    public BaseResponse<List<Product>> listAll(){
        BaseResponse<List<Product>> baseResponse;
        baseResponse = BaseResponse.<List<Product>>builder().data(productService.ListAll()).build();
        return  baseResponse;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long productId){
        productService.deleteProduct(productId);
        return  "Success";
    }

    @GetMapping("/{offset}/{pageSize}/{category}")
    private PageResponse<Product> productPagination(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String category){
        return productService.productPagination(offset, pageSize, category);

    }
}

