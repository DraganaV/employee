package com.example.company.mapper;

import com.example.company.dto.Company;
import com.example.company.dto.CompanyRequest;
import com.example.company.dto.EmployeeRequest;
import com.example.company.model.CompanyEntity;
import com.example.company.model.EmployeeEntity;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    Company fromEntityToCompany(CompanyEntity companyEntity);
    default CompanyEntity fromCompanyToEntity(CompanyRequest company) {
        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity.setName(company.getName());
        companyEntity.setAddress(company.getAddress());
        companyEntity.setDomain(company.getDomain());
        companyEntity.setEmail(company.getEmail());

        List<EmployeeEntity> employeeEntities = new ArrayList<>();

        for(EmployeeRequest employee : company.getEmployees()) {

            EmployeeEntity employeeEntity = new EmployeeEntity();
            employeeEntity.setFirstName(employee.getFirstName());
            employeeEntity.setLastName(employee.getLastName());
            employeeEntity.setAddress(employee.getAddress());
            employeeEntity.setCompany(companyEntity);
            employeeEntity.setEmail(employee.getEmail());
            employeeEntity.setDepartment(employee.getDepartment());
            employeeEntity.setSalary(employee.getSalary());
            employeeEntity.setTitle(employee.getTitle());

            employeeEntities.add(employeeEntity);
        }

        companyEntity.setEmployees(employeeEntities);

        return companyEntity;
    }
}
