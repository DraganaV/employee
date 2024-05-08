package com.example.company.service;

import com.example.company.constants.MessageConstants;
import com.example.company.dto.Company;
import com.example.company.exceptions.DataNotFoundException;
import com.example.company.mapper.CompanyMapper;
import com.example.company.model.CompanyEntity;
import com.example.company.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    public List<Company> getAllCompanies() {
        log.info("Fetching companies info ...");
        List<CompanyEntity> companies = companyRepository.findAll();

        if (companies.isEmpty()) {
            log.warn(MessageConstants.NO_COMPANIES_INFO_AVAILABLE);
            throw new DataNotFoundException(MessageConstants.NO_COMPANIES_INFO_AVAILABLE);
        }

        return companies
                .stream()
                .map(companyMapper::fromEntityToCompany)
                .collect(Collectors.toList());
    }

    public Company getCompanyById(int id) {
        log.info("Fetching company info for company id = {}", id);

        return companyRepository
                .findById(id)
                .map(companyMapper::fromEntityToCompany)
                .orElseThrow(()-> {
                    log.warn(MessageConstants.NO_COMPANY_INFO_AVAILABLE);
                    throw new DataNotFoundException(MessageConstants.NO_COMPANY_INFO_AVAILABLE + id);
                });
    }
}
