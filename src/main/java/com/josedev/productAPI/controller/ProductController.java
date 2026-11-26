package com.josedev.productAPI.controller;

import com.josedev.productAPI.database.model.ProductEntity;
import com.josedev.productAPI.dto.ProductDto;
import com.josedev.productAPI.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/product")
@Validated
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductEntity> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductEntity findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductEntity save(@RequestBody @Valid ProductDto product) {
        return productService.save(product);
    }

}
