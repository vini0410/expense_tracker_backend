package com.project.expensetracker.adapters.web.mappers;

import com.project.expensetracker.adapters.web.dtos.ExpenseDto;
import com.project.expensetracker.domains.models.Expense;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExpenseDtoMapper {

    Expense toModel(ExpenseDto expenseDto);

    ExpenseDto toDto(Expense expense);

}
