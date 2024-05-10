package com.example.company.repository;

import com.example.company.model.QUserEntity;
import com.example.company.model.UserEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public Optional<UserEntity> findUserByUsername(String username) {
        QUserEntity qUserEntity = QUserEntity.userEntity;

        return Optional.ofNullable(
                jpaQueryFactory
                .selectFrom(qUserEntity)
                .where(qUserEntity.username.eq(username))
                .fetchOne()
        );
    }
}
