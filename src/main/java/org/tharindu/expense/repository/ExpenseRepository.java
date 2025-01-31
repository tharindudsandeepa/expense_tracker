package org.tharindu.expense.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tharindu.expense.entity.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long> {
}
