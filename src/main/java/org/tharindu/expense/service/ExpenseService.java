package org.tharindu.expense.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.tharindu.expense.entity.Expense;

import java.util.List;

public interface ExpenseService {
    Page<Expense> getAllExpenses(Pageable page);
    Expense getExpenseById(Long id);
    void deleteExpenseById(Long id);
    Expense addExpense(Expense expense);
    Expense updateExpense(Long id,Expense expense);
}
