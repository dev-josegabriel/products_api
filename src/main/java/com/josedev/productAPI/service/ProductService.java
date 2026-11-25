package com.josedev.productAPI.service;

import com.josedev.productAPI.database.model.ProductEntity;
import com.josedev.productAPI.database.repository.iProductRepository;
import com.josedev.productAPI.dto.ProductDto;
import com.josedev.productAPI.exception.ProductNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final iProductRepository iProductRepository;

    public List<ProductEntity> findAll() {
        return iProductRepository.findAll();
    }

    public ProductEntity findById(Long id) {
        return iProductRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with id " + id + " not found"));
    }

    public ProductEntity save(ProductDto productDto) {
        ProductEntity product = ProductEntity.builder()
                .name(productDto.getName())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .stock(productDto.getStock())
                .build();
        return iProductRepository.save(product);
    }

}
