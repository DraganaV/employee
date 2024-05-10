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
public class CompanyRequest {
    private String name;
    private String domain;
    private String address;
    private String email;
    private List<EmployeeRequest> employees;
}
