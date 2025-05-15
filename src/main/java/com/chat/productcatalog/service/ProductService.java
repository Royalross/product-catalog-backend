package com.chat.productcatalog.service;

import com.chat.productcatalog.model.Product;
import com.chat.productcatalog.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public List<Product> getProductsByCategory(Long categoryId){
        return productRepository.findAllByCategoryId(categoryId);
    }
}
