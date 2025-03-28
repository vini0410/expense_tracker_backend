package com.project.expensetracker.adapters.web.controllers;

import com.project.expensetracker.adapters.web.dtos.ExpenseDto;
import com.project.expensetracker.adapters.web.mappers.ExpenseDtoMapper;
import com.project.expensetracker.domains.usecases.ExpenseUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/expenses")
public class ExpenseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExpenseController.class);

    private final ExpenseUseCase useCase;

    private final ExpenseDtoMapper mapper;

    @PostMapping
    public ExpenseDto postExpense(@RequestBody @Valid ExpenseDto expense) {
        LOGGER.info("POST Expense {}", expense);
        var res = useCase.createExpense(mapper.toModel(expense));
        return mapper.toDto(res);
    }

    @PatchMapping("/{id}")
    public ExpenseDto patchExpense(@PathVariable String id, @RequestBody @Valid ExpenseDto expense) {
        LOGGER.info("PATCH Expense {}", id);
        var res = useCase.updateExpense(id, mapper.toModel(expense));
        return mapper.toDto(res);
    }

    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable String id) {
        LOGGER.info("DELETE Expense {}", id);
        useCase.deleteExpense(id);
    }

    @GetMapping("/{id}")
    public ExpenseDto getExpenseById(@PathVariable String id) {
        LOGGER.info("GET Expense: {}", id);
        var res = useCase.findExpenseById(id);
        return mapper.toDto(res);
    }

    @GetMapping("/category")
    public List<ExpenseDto> getExpensesByCategory(@RequestParam String user, @RequestParam String category) {
        LOGGER.info("GET Expenses by User: {} and Category: {}", user, category);
        var res = useCase.listExpensesByCategory(user, category);
        return res.stream().map(mapper::toDto).toList();
    }

    @GetMapping
    public List<ExpenseDto> getExpenses() {
        LOGGER.info("GET Expenses");
        var res = useCase.listExpenses();
        return res.stream().map(mapper::toDto).toList();
    }

    @GetMapping("/user")
    public List<ExpenseDto> getExpensesByUserId(@RequestParam String user) {
        LOGGER.info("GET Expenses by UserId: {}", user);
        var res = useCase.listExpensesByUserId(user);
        return res.stream().map(mapper::toDto).toList();
    }


}
