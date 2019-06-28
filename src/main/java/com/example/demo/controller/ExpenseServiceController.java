package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Expense;
import com.example.demo.service.ExpenseService;

@RestController
public class ExpenseServiceController {

	@Autowired
	ExpenseService expenseService;
	
	@RequestMapping(value = "/expenses/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable("id") String id) {
		expenseService.deleteExpense(Long.parseLong(id));
		return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/expenses/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Expense expense) {
		expenseService.deleteExpense(Long.parseLong(id));
		return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/expenses", method = RequestMethod.POST)
	public ResponseEntity<Object> createExpense(@RequestBody Expense expense) {
		expenseService.createExpense(expense);
		return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
	}

	@GetMapping(value = "/expenses")
	public ResponseEntity<Object> getExpenses() {
		return new ResponseEntity<>(expenseService.getExpenses(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/expenses/{id:[0-9]+}")
	public ResponseEntity<Object> getExpenses(@PathVariable("id") String id) {
		return new ResponseEntity<>(expenseService.getExpense(Long.parseLong(id)), HttpStatus.OK);
	}
}