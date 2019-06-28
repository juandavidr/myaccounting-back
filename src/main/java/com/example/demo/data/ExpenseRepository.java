package com.example.demo.data;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Expense;

public interface ExpenseRepository extends CrudRepository<Expense, Long> {
	@Query("SELECT u FROM Expense u WHERE u.description LIKE CONCAT('%',:name,'%')")
	List<Expense> findByName(@Param("name") String name);
}