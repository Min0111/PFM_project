package com.pfm.project.domain.product;

import com.pfm.project.domain.store.Store;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "PRODUCT")
public class Product {
    // 상품 아이디
    @Id
    @GeneratedValue
    @Column(name = "product_id", nullable = false)
    private int id;

    // 상품명
    @Column(name="product_name", nullable = false)
    private String productName;

    // 상품 가격
    @Column(name="price", nullable = false)
    private int price;



    @ManyToOne(targetEntity = Store.class, fetch = FetchType.LAZY)
    @JoinColumn(name="store_id")
    private Store store;

    @Builder
    public Product(String productName, int price) {
        this.price = price;
        this.productName =productName;
    }

//    public List<Store> product(String search){
//
//
//
//
//
//        return id;
//
////
////        List<Product> products = this.product.stream()
////                .filter(history -> history.getProductName().equals(seaㅡㅁrch))
////                .collect(Collectors.toList());
////        List<Long> id = new ArrayList<>();
////
////        for (int i=0;i<products.size();i++){
////            id.add(products.get(i).getStoreid());
////        }
////
////        return id;
//
//
//    }


}
