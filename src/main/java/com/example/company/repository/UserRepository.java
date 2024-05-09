package com.example.company.repository;

import com.example.company.model.QUserEntity;
import com.example.company.model.UserEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final EntityManager entityManager;

    public Optional<UserEntity> findUserByUsername(String username) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        QUserEntity qUserEntity = QUserEntity.userEntity;

        return Optional.ofNullable(
                queryFactory
                .selectFrom(qUserEntity)
                .where(qUserEntity.username.eq(username))
                .fetchOne()
        );
    }
}
