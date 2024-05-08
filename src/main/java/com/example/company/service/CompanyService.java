package com.example.company.service;

import com.example.company.dto.Company;
import com.example.company.exceptions.DataNotFoundException;
import com.example.company.mapper.CompanyMapper;
import com.example.company.model.CompanyEntity;
import com.example.company.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    public List<Company> getAllCompanies() {
        List<CompanyEntity> companies = companyRepository.findAll();

        if (companies.isEmpty()) {
            throw new DataNotFoundException("No companies info available.");
        }

        return companies
                .stream()
                .map(companyMapper::fromEntityToCompany)
                .collect(Collectors.toList());
    }
}
