package com.assignment.Assignment.controller;

import com.assignment.Assignment.controller.Request.EmployeeRequest;
import com.assignment.Assignment.entity.Employee;
import com.assignment.Assignment.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = this.employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody EmployeeRequest employeeRequest){
        Employee newEmployee = this.employeeService.saveEmployee(employeeRequest);
        return ResponseEntity.ok(newEmployee);
    }
}
