package com.example.E_commerce.ServiceImpl;

import com.example.E_commerce.BaseReponse.PageResponse;
import com.example.E_commerce.DTO.ProductDTO;
import com.example.E_commerce.Entity_or_Model.Product;
import com.example.E_commerce.Repository.ProductRepo;
import com.example.E_commerce.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public Product AddProduct(ProductDTO productDTO){
        Product product =new Product();
        product.setCategory(productDTO.getCategory());
        product.setProductName(productDTO.getProductName());
        product.setPrize(productDTO.getPrize());
        productRepo.save(product);
        return product;
    }

    @Override
    public Optional<Product> UpdateByProductId(ProductDTO productDTO){

        Optional<Product> exitsProduct = productRepo.findById(productDTO.getProductId());

            exitsProduct.get().setProductId(productDTO.getProductId());
            exitsProduct.get().setCategory(productDTO.getCategory());
            exitsProduct.get().setProductName(productDTO.getProductName());
            exitsProduct.get().setPrize(productDTO.getPrize());

        productRepo.save(exitsProduct.get());
        return  exitsProduct;

    }
    @Override
    public  Product deleteProduct (Long productId){
          Product product = new Product();
          productRepo.deleteById(productId);
          return product;
    }

    @Override
    public List<Product> ListAll(){
        List<Product> obj = productRepo.findAll();
        return obj;
    }

    @Override
    public PageResponse<Product> productPagination(int offset, int pageSize, String category){

        Pageable paging= PageRequest.of(offset,pageSize);
        Page<Product> products=productRepo.searchAllByCategoryLike("%"+ category +"%", paging);
        PageResponse pageResponse = new PageResponse();
        pageResponse.setResponse(products);
        pageResponse.setRecordCount(products.getTotalPages());
        return pageResponse;

    }
}

