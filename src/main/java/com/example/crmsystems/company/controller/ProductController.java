package com.example.crmsystems.company.controller;

import com.example.crmsystems.company.model.Product;
import com.example.crmsystems.company.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping("/")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
//        Product prod = service.save(product);
//        return product != null
//                ? new ResponseEntity<>(prod, HttpStatus.CREATED)
//                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(service.save(product), HttpStatus.CREATED);
    }
}
