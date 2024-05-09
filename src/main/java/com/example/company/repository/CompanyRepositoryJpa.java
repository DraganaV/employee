package com.example.company.repository;

import com.example.company.model.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepositoryJpa extends JpaRepository<CompanyEntity, Integer> {
}
