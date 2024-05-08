package com.example.company.controller;

import com.example.company.dto.Company;
import com.example.company.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping("/")
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }
}
