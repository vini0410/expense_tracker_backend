package com.project.expensetracker.adapters.repositorys.services;

import com.project.expensetracker.adapters.repositorys.jpa.ExpenseRepository;
import com.project.expensetracker.adapters.repositorys.mappers.ExpenseEntityMapper;
import com.project.expensetracker.domains.models.Expense;
import com.project.expensetracker.ports.repositorys.ExpensePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpensePortImpl implements ExpensePort {

    private final ExpenseRepository repository;

    private final ExpenseEntityMapper mapper;

    @Override
    public Expense saveExpense(Expense expense) {
        var savedExpense = repository.save(mapper.toEntity(expense));
        return mapper.toModel(savedExpense);
    }

    @Override
    public void deleteExpense(String id) {
        repository.deleteById(id);

    }

    @Override
    public Expense findExpenseById(String id) {
        var res = repository.findById(id).orElse(null);
        return mapper.toModel(res);
    }

    @Override
    public List<Expense> listExpenses() {
        var res = repository.findAll();
        return res.stream().map(mapper::toModel).toList();
    }

    @Override
    public List<Expense> listExpensesByUserId(String userId) {
        var res = repository.findAllByUserId(userId);
        return res.stream().map(mapper::toModel).toList();
    }
}
