package org.tharindu.expense.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.tharindu.expense.entity.Expense;
import org.tharindu.expense.exceptions.ResourceNotFound;
import org.tharindu.expense.repository.ExpenseRepository;

import java.util.Optional;

@Service
public class ExpenseServiceImplementation implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public Page<Expense> getAllExpenses(Pageable page) {
        return expenseRepository.findAll(page);
    }
    @Override
    public Expense getExpenseById(Long id) {
        Optional<Expense> expense =expenseRepository.findById(id);
        if (expense.isPresent()) {
            return expense.get();
        }
        else{
            throw new ResourceNotFound("Expense not found for id " + id);
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

    @Override
    public Expense updateExpense(Long id, Expense expense) {
        Expense existingExpense = getExpenseById(id);
        existingExpense.setName(expense.getName()!=null?expense.getName():existingExpense.getName());
        existingExpense.setDescription(expense.getDescription()!=null?expense.getDescription():existingExpense.getDescription());
        existingExpense.setCategory(expense.getCategory()!=null?expense.getCategory():existingExpense.getCategory());
        existingExpense.setAmount(expense.getAmount()!=null?expense.getAmount():existingExpense.getAmount());
        existingExpense.setDate(expense.getDate()!=null?expense.getDate():existingExpense.getDate());
        return expenseRepository.save(existingExpense);
    }


}
