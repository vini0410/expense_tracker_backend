package com.project.expensetracker.domains.usecases;

import com.project.expensetracker.domains.models.Expense;
import com.project.expensetracker.ports.repositorys.ExpensePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class ExpenseUseCase {

    private final ExpensePort port;

    public Expense createExpense(Expense expense) {
        return port.saveExpense(expense);
    }

    public Expense updateExpense(String id, Expense model) {
        var expense = port.findExpenseById(id);
        if (Objects.isNull(expense)) {
            return null; // throw error
        }
        model.setId(id);
        return port.saveExpense(model);
    }

    public void deleteExpense(String id) {
        var expense = port.findExpenseById(id);
        if (Objects.isNull(expense)) {
            return; // throw error
        }
        port.deleteExpense(id);
    }

    public Expense findExpenseById(String id) {
        var expense = port.findExpenseById(id);
        if (Objects.isNull(expense)) {
            return null; // throw error
        }
        return expense;
    }

    public List<Expense> listExpensesByCategory(String user, String category) {
        return port.listExpensesByCategory(user, category);
    }

    public List<Expense> listExpenses() {
        return port.listExpenses();
    }

    public List<Expense> listExpensesByUserId(String userId) {
        return port.listExpensesByUserId(userId);
    }

}
