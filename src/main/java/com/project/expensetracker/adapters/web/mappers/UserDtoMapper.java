package com.project.expensetracker.adapters.web.mappers;

import com.project.expensetracker.adapters.web.dtos.UserDto;
import com.project.expensetracker.domains.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserDtoMapper {
    UserDtoMapper INSTANCE = Mappers.getMapper(UserDtoMapper.class);

    User toModel(UserDto dto);

    UserDto toDto(User model);
}
