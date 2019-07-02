package com.example.demo.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.ExpenseRepository;
import com.example.demo.model.Expense;
import com.example.demo.service.interfaces.ExpenseService;

@Service
public class ExpenseServiceImpl implements ExpenseService {
	@Autowired
	ExpenseRepository repository;

	@Override
	public void createExpense(Expense expense) {
		expense.setCreateDate(LocalDateTime.now());
		expense.setUpdateDate(LocalDateTime.now());
		repository.save(expense);

	}

	@Override
	public void updateExpense(Long id, Expense expense) {
		expense.setUpdateDate(LocalDateTime.now());
		repository.save(expense);
	}

	@Override
	public void deleteExpense(Long id) {
		repository.deleteById(id);
	}

	@Override
	public Collection<Expense> getExpenses() {
		Collection<Expense> cltn = new ArrayList<Expense>();
		repository.findAll().forEach(cltn::add);
		return cltn;
	}

	@Override
	public Expense getExpense(Long id) {		
		return repository.findById(id).get();
	}
}