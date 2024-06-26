package com.example.company.dto;

import com.example.company.model.EmployeeEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Company {

    private Integer id;
    private String name;
    private String domain;
    private String address;
    private String email;
    private List<EmployeeEntity> employees;
}
