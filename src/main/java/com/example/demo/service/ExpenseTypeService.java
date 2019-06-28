package com.example.demo.service;

import java.util.Collection;

import com.example.demo.model.ExpenseType;

public interface ExpenseTypeService {
   public abstract void createExpenseType(ExpenseType expenseType);
   public abstract void updateExpenseType(Long id, ExpenseType expenseType);
   public abstract void deleteExpenseType(Long id);
   public abstract Collection<ExpenseType> getExpenseTypes();
   public abstract ExpenseType getExpenseType(Long id);
}