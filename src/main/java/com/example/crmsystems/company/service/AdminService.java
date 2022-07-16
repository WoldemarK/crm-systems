package com.example.crmsystems.company.service;

import com.example.crmsystems.company.model.Admin;
import com.example.crmsystems.company.model.Employee;
import com.example.crmsystems.company.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {
    private AdminRepository adminRepository;



    public Admin save(Employee employee) {
        Admin admin = new Admin();
        admin.getEmployee(this);
        return adminRepository.save(admin);
    }
}
