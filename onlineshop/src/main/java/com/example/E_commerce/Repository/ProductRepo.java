package com.example.E_commerce.Repository;

import com.example.E_commerce.Entity_or_Model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {

    Page<Product> searchAllByCategoryLike(String s, Pageable paging);

    Product findByProductId(Long productId);
}
