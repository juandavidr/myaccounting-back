package com.example.demo.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.ExpenseTypeRepository;
import com.example.demo.model.ExpenseType;
import com.example.demo.service.interfaces.ExpenseTypeService;

@Service
public class ExpenseTypeServiceImpl implements ExpenseTypeService {
	@Autowired
	ExpenseTypeRepository repository;

	@Override
	public void createExpenseType(ExpenseType expense) {
		expense.setCreateDate(LocalDateTime.now());
		expense.setUpdateDate(LocalDateTime.now());
		repository.save(expense);

	}

	@Override
	public void updateExpenseType(Long id, ExpenseType expense) {
		expense.setUpdateDate(LocalDateTime.now());
		repository.save(expense);
	}

	@Override
	public void deleteExpenseType(Long id) {
		repository.deleteById(id);
	}

	@Override
	public Collection<ExpenseType> getExpenseTypes() {
		Collection<ExpenseType> cltn = new ArrayList<ExpenseType>();
		repository.findAll().forEach(cltn::add);
		return cltn;
	}

	@Override
	public ExpenseType getExpenseType(Long id) {		
		return repository.findById(id).get();
	}
}