package org.tharindu.expense.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tharindu.expense.entity.Expense;
import org.tharindu.expense.service.ExpenseService;

import java.util.List;

@RestController
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;
    @GetMapping("/expenses")
    public List<Expense> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

    @GetMapping("/expenses/{id}")
    public Expense getExpenseById(@PathVariable("id") long id) {
        return expenseService.getExpenseById(id);
    }

    @DeleteMapping("/expenses")
    public void deleteExpenseById(@RequestParam long id) {
         expenseService.deleteExpenseById(id);
    }

    @PostMapping("/expenses")
    public Expense addExpense(@RequestBody Expense expense) {
        return expenseService.addExpense(expense);
    }
    @PutMapping("/expenses/{id}")
    public Expense updateExpense(@PathVariable("id") long id, @RequestBody Expense expense) {
        return expenseService.updateExpense(id, expense);
    }


}
