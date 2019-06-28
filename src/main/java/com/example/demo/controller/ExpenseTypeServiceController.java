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

import com.example.demo.model.ExpenseType;
import com.example.demo.service.ExpenseTypeService;

@RestController
public class ExpenseTypeServiceController {

	@Autowired
	ExpenseTypeService expenseService;
	
	@RequestMapping(value = "/expenses-types/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable("id") String id) {
		expenseService.deleteExpenseType(Long.parseLong(id));
		return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/expenses-types/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody ExpenseType expense) {
		expenseService.deleteExpenseType(Long.parseLong(id));
		return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/expenses-types", method = RequestMethod.POST)
	public ResponseEntity<Object> createExpense(@RequestBody ExpenseType expense) {
		expenseService.createExpenseType(expense);
		return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
	}

	@GetMapping(value = "/expenses-types")
	public ResponseEntity<Object> getExpenseTypes() {
		return new ResponseEntity<>(expenseService.getExpenseTypes(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/expenses-types/{id:[0-9]+}")
	public ResponseEntity<Object> getExpenseType(@PathVariable("id") String id) {
		return new ResponseEntity<>(expenseService.getExpenseType(Long.parseLong(id)), HttpStatus.OK);
	}
}