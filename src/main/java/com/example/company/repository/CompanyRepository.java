package com.example.company.repository;

import com.example.company.model.CompanyEntity;
import com.example.company.model.QCompanyEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CompanyRepository {

    private final EntityManager entityManager;

    public Optional<CompanyEntity> getCompanyById(Integer id) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        QCompanyEntity qCompanyEntity = QCompanyEntity.companyEntity;

        return Optional.ofNullable(
                queryFactory
                .selectFrom(qCompanyEntity)
                .where(qCompanyEntity.id.eq(id))
                .fetchOne()
        );
    }
}
