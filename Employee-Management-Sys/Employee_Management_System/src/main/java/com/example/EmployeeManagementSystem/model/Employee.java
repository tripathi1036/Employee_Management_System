package com.example.EmployeeManagementSystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    private int id;
    @Column(name = "first_name",nullable = false)
    private String firstname;
    @Column(name ="last_name")
    private String lastname;
    @Column(name = "email",nullable = false)
    private String email;
}