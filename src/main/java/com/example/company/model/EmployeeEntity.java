package com.example.company.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class EmployeeEntity {

    @Id
    private Integer id;

    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String title;
    private Double salary;
    private String department;

    @ManyToOne
    private CompanyEntity company;
}
