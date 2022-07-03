package com.example.crmsystems.сlient.controller;

import com.example.crmsystems.сlient.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService service;

    @GetMapping
    public ResponseEntity<String>getString(){
        return new ResponseEntity<>("Тестирование контроллера Customer", HttpStatus.OK);
    }
}
