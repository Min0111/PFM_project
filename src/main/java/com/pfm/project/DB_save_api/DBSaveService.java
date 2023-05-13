package com.pfm.project.DB_save_api;

import com.pfm.project.domain.product.Product;
import com.pfm.project.domain.store.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class DBSaveService {
    private final API_Store_Repository storeRepository;
    private final API_Product_Repository productRepository;

    @Autowired
    public DBSaveService(API_Store_Repository storeRepository, API_Product_Repository productRepository) {
        this.storeRepository = storeRepository;
        this.productRepository = productRepository;
    }

    @Transactional
    public void saveStoreDB(List<Store> req) {
        storeRepository.saveAll(req);
    }

    @Transactional
    public void saveProductDB(List<ProductApiDTO> req) {

        List<Product> saveProducts = new ArrayList<>();

        for (ProductApiDTO p: req) {
            Product product = Product.builder()
                    .price(p.getProductPrice())
                    .store(storeRepository.findById(p.getId()).orElseThrow())
                    .productName(p.getProductName()).build();

            saveProducts.add(product);
        }

        productRepository.saveAll(saveProducts);
    }
}
