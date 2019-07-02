package com.example.demo.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.PaymentTypeRepository;
import com.example.demo.model.PaymentType;
import com.example.demo.service.interfaces.PaymentTypeService;

@Service
public class PaymentTypeServiceImpl implements PaymentTypeService {
	@Autowired
	PaymentTypeRepository repository;

	@Override
	public void createPaymentType(PaymentType expense) {
		expense.setCreateDate(LocalDateTime.now());
		expense.setUpdateDate(LocalDateTime.now());
		repository.save(expense);

	}

	@Override
	public void updatePaymentType(Long id, PaymentType expense) {
		expense.setUpdateDate(LocalDateTime.now());
		repository.save(expense);
	}

	@Override
	public void deletePaymentType(Long id) {
		repository.deleteById(id);
	}

	@Override
	public Collection<PaymentType> getPaymentTypes() {
		Collection<PaymentType> cltn = new ArrayList<PaymentType>();
		repository.findAll().forEach(cltn::add);
		return cltn;
	}

	@Override
	public PaymentType getPaymentType(Long id) {		
		return repository.findById(id).get();
	}
}