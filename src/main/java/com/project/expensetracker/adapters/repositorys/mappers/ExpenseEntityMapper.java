package com.project.expensetracker.adapters.repositorys.mappers;

import com.project.expensetracker.adapters.repositorys.entitys.ExpenseEntity;
import com.project.expensetracker.domains.models.Expense;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExpenseEntityMapper {

    Expense toModel(ExpenseEntity expenseEntity);

    ExpenseEntity toEntity(Expense expense);
}
