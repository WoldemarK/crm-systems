package com.example.crmsystems.сlient.service;

import com.example.crmsystems.сlient.model.Customer;
import com.example.crmsystems.сlient.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;

    public Customer save(Customer customer) {
        return repository.save(customer);
    }

    public Optional<Customer> findById(long id) {
        return repository.findById(id);
    }

    public List<Customer> findAll() {
        return repository.findAll();
    }

    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
