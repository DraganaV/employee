package com.example.company.mapper;

import com.example.company.dto.User;
import com.example.company.model.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User fromEntityToUser(UserEntity userEntity);
}
