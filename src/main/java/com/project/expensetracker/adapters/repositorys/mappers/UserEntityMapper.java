package com.project.expensetracker.adapters.repositorys.mappers;

import com.project.expensetracker.adapters.repositorys.entitys.UserEntity;
import com.project.expensetracker.domains.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {

    User toModel(UserEntity entity);

    UserEntity toEntity(User model);
}
