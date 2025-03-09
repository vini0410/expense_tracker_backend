package com.project.expensetracker.ports.repositorys;

import com.project.expensetracker.domains.models.Expense;

import java.util.List;

public interface ExpensePort {
    Expense saveExpense(Expense expense);

    void deleteExpense(String id);

    Expense findExpenseById(String id);

    List<Expense> listExpensesByCategory(String user, String category);

    List<Expense> listExpenses();

    List<Expense> listExpensesByUserId(String userId);


}
