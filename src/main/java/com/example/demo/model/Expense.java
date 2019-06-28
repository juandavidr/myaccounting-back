package com.example.demo.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "expenses")
public class Expense {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "description", length = 45, columnDefinition = "TEXT")
	private String description;
	/**
	 * 
	 */
	@Column(name = "create_date")
	private LocalDateTime createDate;
	/**
	 * 
	 */
	@Column(name = "update_date")
	private LocalDateTime updateDate;
	/**
	 * 
	 */
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "expense_type_id", nullable = false, referencedColumnName = "id" ,foreignKey = @ForeignKey(name = "fk_expense_expense_type"))
	private ExpenseType expenseTypeId;

	/**
	 * 
	 */
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "payment_type_id",nullable = false, referencedColumnName = "id" ,foreignKey = @ForeignKey(name = "fk_expense_payment_type"))
	private PaymentType paymentTypeId;
	
	@Column(name="amount")
	private Double amount;

	protected Expense() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public LocalDateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}

	public ExpenseType getExpenseTypeId() {
		return expenseTypeId;
	}

	public void setExpenseTypeId(ExpenseType expenseTypeId) {
		this.expenseTypeId = expenseTypeId;
	}
	
	

	public PaymentType getPaymentTypeId() {
		return paymentTypeId;
	}

	public void setPaymentTypeId(PaymentType paymentTypeId) {
		this.paymentTypeId = paymentTypeId;
	}
	
	

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return String.format("Customer[id=%d, description='%s']", id, description);
	}

}
