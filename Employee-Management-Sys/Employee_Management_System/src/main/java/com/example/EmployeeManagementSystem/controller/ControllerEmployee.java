package com.example.EmployeeManagementSystem.controller;

import com.example.EmployeeManagementSystem.dto.DtoEmployee;
import com.example.EmployeeManagementSystem.service.ServiceEmployeeIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/employee")
public class ControllerEmployee {

    @Autowired
    private ServiceEmployeeIn serviceEmployee;

    @PostMapping
    public ResponseEntity<DtoEmployee> createEmployee(@RequestBody DtoEmployee dtoEmployee) {
        DtoEmployee e = serviceEmployee.createEmployee(dtoEmployee);
        return new ResponseEntity<>(e, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DtoEmployee> findById(@PathVariable("id") int id) {
        DtoEmployee e = serviceEmployee.findById(id);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<DtoEmployee>> findAllEmployee() {
        List<DtoEmployee> employees = serviceEmployee.findAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DtoEmployee> updateEmployee(
            @PathVariable("id") int id,
            @RequestBody DtoEmployee updatedEmployee) {
        DtoEmployee updatedEmp = serviceEmployee.updateEmployee(id, updatedEmployee);
        return new ResponseEntity<>(updatedEmp, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id) {
        serviceEmployee.deleteEmployee(id);
        return ResponseEntity.ok("This Employee is Deleted successfully");
    }
}
