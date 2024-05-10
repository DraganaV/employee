package com.example.company.controller;

import com.example.company.dto.Company;
import com.example.company.dto.CompanyRequest;
import com.example.company.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping("/")
    public ResponseEntity<List<Company>> getAllCompanies() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(companyService.getAllCompanies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable("id") int id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(companyService.getCompanyById(id));
    }

    @PostMapping("/")
    public ResponseEntity<String> postCompany(@RequestBody CompanyRequest companyRequest) {
        return ResponseEntity.status(HttpStatus.OK)
                .body("Created company with id = " + companyService.postCompany(companyRequest));

    }
}
