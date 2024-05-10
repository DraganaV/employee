package com.example.company.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class EmployeeRequest {

    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String title;
    private Double salary;
    private String department;
}
