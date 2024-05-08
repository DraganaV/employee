package com.example.company.mapper;

import com.example.company.dto.Company;
import com.example.company.model.CompanyEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    Company fromEntityToCompany(CompanyEntity companyEntity);
}
