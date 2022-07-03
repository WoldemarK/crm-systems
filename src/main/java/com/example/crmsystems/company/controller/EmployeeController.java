package com.example.crmsystems.company.controller;

import com.example.crmsystems.company.model.Employee;
import com.example.crmsystems.company.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @PostMapping("/add")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee empl = service.save(employee);
        return employee != null
                ? new ResponseEntity<>(empl, HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Employee>> getAllEmployee() {
        List<Employee> empl = service.findAll();
        return empl != null
                ? new ResponseEntity<>(empl, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @GetMapping("/get/{employeeId}")
    public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable Long employeeId) {
        return Optional.ofNullable(service.findById(employeeId))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("get")
    public ResponseEntity<Optional<Employee>> getAllEmployeeParam(@RequestParam(required = false) Long employeeId) {
        return Optional.ofNullable(service.findById(employeeId))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping
    public ResponseEntity<String> deleteById(@PathVariable Long employeeId) {
        service.deleteById(employeeId);
        return new ResponseEntity<>("Employee deleted successfully!.", HttpStatus.OK);
    }

    @PutMapping("/emp/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "employeeId") Long employeeId,
                                                   @RequestBody Employee empl) throws Exception {

        Employee employee = service.findById(employeeId)
                .orElseThrow(() -> new Exception("Employee not found for this id :: " + employeeId));

        employee.setFirstName(empl.getFirstName());
        employee.setListName(empl.getListName());
        employee.setPhoneNumber(empl.getPhoneNumber());
        employee.setBirthday(empl.getBirthday());
        employee.setEmail(empl.getEmail());
        employee.setSalary(empl.getSalary());
        employee.setDepartment(empl.getDepartment());
        employee.setPost(empl.getPost());

        Employee updated = service.save(employee);

        return new ResponseEntity<>(updated, HttpStatus.OK);

    }

    @PatchMapping("/emp/{employeeId}/{firstName}")
    public ResponseEntity<Employee> updateEmployeePartially(@PathVariable Long employeeId,
                                                            @PathVariable String firstName) {
        try {
            Employee employee = service.findById(employeeId).get();
            employee.setFirstName(firstName);
            return new ResponseEntity<>(service.save(employee), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}