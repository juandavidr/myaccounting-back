package com.example.demo.service.interfaces;

import java.util.Collection;

import com.example.demo.model.Expense;

public interface ExpenseService {
   public abstract void createExpense(Expense product);
   public abstract void updateExpense(Long id, Expense product);
   public abstract void deleteExpense(Long id);
   public abstract Collection<Expense> getExpenses();
   public abstract Expense getExpense(Long id);
}