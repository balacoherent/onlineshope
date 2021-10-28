package com.example.E_commerce.Entity_or_Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "product")
@Getter
@Setter
@SQLDelete(sql = "UPDATE Product SET is_delete =1 WHERE product_id= ?")
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @NotNull
    @Column(name = "category")
    private String category;

    @NotNull
    @Column(name = "product_name")
    private  String productName;

    @NotNull
    @Column(name = "prize")
    private int prize;

    @Column(name = "is_active",columnDefinition = "integer default 0")
    private int isActive ;

    @Column(name = "is_delete",columnDefinition = "integer default 0")
    private int isDelete ;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


}
