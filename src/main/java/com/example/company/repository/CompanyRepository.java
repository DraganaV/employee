package com.example.company.repository;

import com.example.company.model.CompanyEntity;
import com.example.company.model.QCompanyEntity;
import com.querydsl.core.types.EntityPath;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CompanyRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public Optional<CompanyEntity> findCompanyById(Integer id) {
        QCompanyEntity qCompanyEntity = QCompanyEntity.companyEntity;

        return Optional.ofNullable(
                jpaQueryFactory
                .selectFrom(qCompanyEntity)
                .where(qCompanyEntity.id.eq(id))
                .fetchOne()
        );
    }

    public long postCompany(CompanyEntity companyEntity) {
        QCompanyEntity qCompanyEntity = QCompanyEntity.companyEntity;

        long id = jpaQueryFactory
                .insert(qCompanyEntity)
                .set(qCompanyEntity.name, companyEntity.getName())
                .set(qCompanyEntity.domain, companyEntity.getDomain())
                .set(qCompanyEntity.address, companyEntity.getAddress())
                .set(qCompanyEntity.email, companyEntity.getEmail())
                .set(qCompanyEntity.employees, companyEntity.getEmployees())
                .execute();

        return id;
    }

}
