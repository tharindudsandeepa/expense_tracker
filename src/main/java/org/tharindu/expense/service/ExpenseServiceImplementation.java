package org.tharindu.expense.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tharindu.expense.entity.Expense;
import org.tharindu.expense.repository.ExpenseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseServiceImplementation implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }
    @Override
    public Expense getExpenseById(Long id) {
        Optional<Expense> expense =expenseRepository.findById(id);
        if (expense.isPresent()) {
            return expense.get();
        }
        else{
            throw new RuntimeException("Expense not found");
        }
    }

    @Override
    public void deleteExpenseById(Long id) {
        expenseRepository.deleteById(id);
    }

    @Override
    public Expense addExpense(Expense expense) {
        return expenseRepository.save(expense);
    }


}
