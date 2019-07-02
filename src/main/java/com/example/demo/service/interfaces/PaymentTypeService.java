package com.example.demo.service.interfaces;

import java.util.Collection;

import com.example.demo.model.PaymentType;

public interface PaymentTypeService {
   public abstract void createPaymentType(PaymentType expenseType);
   public abstract void updatePaymentType(Long id, PaymentType expenseType);
   public abstract void deletePaymentType(Long id);
   public abstract Collection<PaymentType> getPaymentTypes();
   public abstract PaymentType getPaymentType(Long id);
}