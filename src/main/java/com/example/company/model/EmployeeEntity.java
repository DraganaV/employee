package com.example.company.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employee")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String title;
    private Double salary;
    private String department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(columnDefinition = "company_id")
    private CompanyEntity company;
}
