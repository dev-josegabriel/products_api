package com.josedev.productAPI.service;

import com.josedev.productAPI.database.model.ProductEntity;
import com.josedev.productAPI.database.repository.iProductRepository;
import com.josedev.productAPI.exception.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final iProductRepository iProductRepository;

    public ProductService(iProductRepository iProductRepository) {
        this.iProductRepository = iProductRepository;
    }

    public List<ProductEntity> findAll() {
        return iProductRepository.findAll();
    }

    public ProductEntity findById(Long id) {
        return iProductRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with id " + id + " not found"));
    }

}
