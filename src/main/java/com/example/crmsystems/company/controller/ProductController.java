package com.example.crmsystems.company.controller;

import com.example.crmsystems.company.model.Product;
import com.example.crmsystems.company.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping("/")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return new ResponseEntity<>(service.save(product), HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Product>> getAllProduct() {
        List<Product> empl = service.findAll();
        return empl != null
                ? new ResponseEntity<>(empl, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @GetMapping("/get/{productId}")
    public ResponseEntity<Optional<Product>> getEmployeeById(@PathVariable Long productId) {
        return Optional.ofNullable(service.findById(productId))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/get")
    public ResponseEntity<Optional<Product>> getAllEmployeeParam(@RequestParam(required = false) Long productId) {
        return Optional.ofNullable(service.findById(productId))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<String> deleteById(@PathVariable Long productId) {
        service.deleteById(productId);
        return new ResponseEntity<>("Product deleted successfully!.", HttpStatus.OK);
    }

    @PutMapping("/emp/{productId}")
    public ResponseEntity<Product> updateEmployee(@PathVariable(value = "productId") Long productId,
                                                  @RequestBody Product prod) throws Exception {

        Product product = service.findById(productId)
                .orElseThrow(() -> new Exception("Employee not found for this id :: " + productId));

        product.setCost(prod.getCost());
        product.setType(prod.getType());
        product.setModel(prod.getModel());
        product.setBrand(product.getBrand());
        product.setQuantity(prod.getQuantity());
        product.setDescription(prod.getDescription());
        Product updated = service.save(product);

        return new ResponseEntity<>(updated, HttpStatus.OK);

    }


}