package com.project.expensetracker.adapters.web.controllers;

import com.project.expensetracker.adapters.web.dtos.ExpenseDto;
import com.project.expensetracker.adapters.web.mappers.ExpenseDtoMapper;
import com.project.expensetracker.domains.usecases.ExpenseUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/expenses")
public class ExpenseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExpenseController.class);

    @Autowired
    private ExpenseUseCase useCase;

    @Autowired
    private ExpenseDtoMapper mapper;

    @PostMapping
    public ExpenseDto postExpense(@Valid @RequestBody ExpenseDto expense) {
        LOGGER.info("POST Expense");
        var res = useCase.createExpense(mapper.toModel(expense));
        return mapper.toDto(res);
    }

    @PatchMapping("/{id}")
    public ExpenseDto patchExpense(@PathVariable String id) {
        LOGGER.info("PATCH Expense", id);
        var res = useCase.updateExpense(id);
        return mapper.toDto(res);
    }

    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable String id) {
        LOGGER.info("DELETE Expense", id);
        useCase.deleteExpense(id);
    }

    @GetMapping("/{id}")
    public ExpenseDto getExpenseById(@PathVariable String id) {
        LOGGER.info("GET Expense", id);
        var res = useCase.findExpenseById(id);
        return mapper.toDto(res);
    }

    @GetMapping
    public List<ExpenseDto> getExpenses() {
        LOGGER.info("GET Expenses");
        var res = useCase.listExpenses();
        return res.stream().map(mapper::toDto).toList();
    }


}
