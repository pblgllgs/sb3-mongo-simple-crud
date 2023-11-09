package com.pblgllgs.mongo.service;

import com.pblgllgs.mongo.documents.Product;
import com.pblgllgs.mongo.exception.ProductAlreadyExistsException;
import com.pblgllgs.mongo.exception.ProductNotFoundException;
import com.pblgllgs.mongo.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author pblgl
 * Created on 08-11-2023
 */

@Service
@RequiredArgsConstructor
public class ProductService {
    private static final String PRODUCT_NOT_FOUND = "PRODUCT_NOT_FOUND";
    private static final String PRODUCT_ALREADY_EXISTS = "PRODUCT_ALREADY_EXISTS";
    private final ProductRepository productRepository;

    public Product save(Product product) {
        Optional<Product> optional = productRepository.findById(product.getId());
        if (optional.isPresent()) {
            throw new ProductAlreadyExistsException(PRODUCT_ALREADY_EXISTS);
        }
        return productRepository.save(product);
    }

    public Product findById(String id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(PRODUCT_NOT_FOUND));
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void deleteById(String id) {
        Optional<Product> optional = productRepository.findById(id);
        if (optional.isEmpty()) {
            throw new ProductNotFoundException(PRODUCT_NOT_FOUND);
        }
        productRepository.deleteById(id);
    }
}
