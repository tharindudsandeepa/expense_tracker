package org.tharindu.expense.service;

import org.tharindu.expense.entity.Expense;

import java.util.List;

public interface ExpenseService {
    List<Expense> getAllExpenses();
    Expense getExpenseById(Long id);
    void deleteExpenseById(Long id);
    Expense addExpense(Expense expense);
}
