package com.example.crmsystems.company.service;

import com.example.crmsystems.company.model.Employee;
import com.example.crmsystems.company.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repository;


    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    public Optional<Employee> findById(long id) {
        return repository.findById(id);
    }

    public List<Employee> findAll() {
        return repository.findAll();
    }

    public void deleteById(long id) {
        repository.deleteById(id);
    }

}

