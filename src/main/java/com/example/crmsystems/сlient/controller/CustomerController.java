package com.example.crmsystems.сlient.controller;

import com.example.crmsystems.company.model.Employee;
import com.example.crmsystems.сlient.model.Customer;
import com.example.crmsystems.сlient.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService service;

    @GetMapping("/getAll")
    public ResponseEntity<List<Customer>> getAllCustomer() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer cust = service.save(customer);
        return new ResponseEntity<>(cust, HttpStatus.CREATED);
    }

    @GetMapping("/getId/{customerId}")
    public ResponseEntity<Optional<Customer>> getAllCustomer(@PathVariable Long customerId) {
        return Optional.ofNullable(service.findById(customerId))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @GetMapping
    public ResponseEntity<Optional<Customer>> getCustomerParam(@RequestParam(required = false) Long customerId) {
        return Optional.ofNullable(service.findById(customerId))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping
    public ResponseEntity<String> deleteById(@PathVariable Long customerId) {
        service.deleteById(customerId);
        return new ResponseEntity<>("Employee deleted successfully!.", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long customerId, @RequestBody Customer customer) throws Exception {
        Customer cust = service.findById(customerId)
                .orElseThrow(() -> new Exception("Customer not found for this id :: " + customerId));
        Customer updated = service.save(cust);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
}
