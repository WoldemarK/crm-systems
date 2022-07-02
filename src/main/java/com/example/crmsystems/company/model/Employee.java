package com.example.crmsystems.company.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@Table(name = "employees")
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeesId;

    private String firstName;

    private String listName;

    private String phoneNumber;

    private String birthday;

    private String email;

    private Long salary;

    private String department;

    private String post;

}
