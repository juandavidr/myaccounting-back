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

import com.example.demo.model.PaymentType;
import com.example.demo.service.interfaces.PaymentTypeService;

@RestController
public class PaymentTypeServiceController {

	@Autowired
	PaymentTypeService service;
	
	@RequestMapping(value = "/payment-type/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable("id") String id) {
		service.deletePaymentType(Long.parseLong(id));
		return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/payment-type/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody PaymentType object) {
		service.deletePaymentType(Long.parseLong(id));
		return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/payment-type", method = RequestMethod.POST)
	public ResponseEntity<Object> createExpense(@RequestBody PaymentType object) {
		service.createPaymentType(object);
		return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
	}

	@GetMapping(value = "/payment-type")
	public ResponseEntity<Object> getPaymentTypes() {
		return new ResponseEntity<>(service.getPaymentTypes(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/payment-type/{id:[0-9]+}")
	public ResponseEntity<Object> getExpenseType(@PathVariable("id") String id) {
		return new ResponseEntity<>(service.getPaymentType(Long.parseLong(id)), HttpStatus.OK);
	}
}