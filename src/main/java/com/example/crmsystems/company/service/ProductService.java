package com.example.crmsystems.company.service;

import com.example.crmsystems.company.model.Employee;
import com.example.crmsystems.company.model.Product;
import com.example.crmsystems.company.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productsRepository;

    public Product save(Product product) {
        return productsRepository.save(product);
    }

//    public Optional<Product> findById(long id) {
//        return productsRepository.findById(id);
//    }
//
//    public List<Product> findAll() {
//        return productsRepository.findAll();
//    }
//
//    public void deleteById(long id) {
//        productsRepository.deleteById(id);
//    }

}
