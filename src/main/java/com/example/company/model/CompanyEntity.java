package com.example.company.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "company")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CompanyEntity {

    @Id
    private Integer id;

    private String name;
    private String domain;
    private String address;
    private String email;

    @OneToMany(mappedBy = "company")
    private List<EmployeeEntity> employees;
}
