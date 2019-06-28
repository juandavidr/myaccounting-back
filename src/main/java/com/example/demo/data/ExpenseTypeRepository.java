package com.example.demo.data;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.ExpenseType;

public interface ExpenseTypeRepository extends CrudRepository<ExpenseType, Long> {
	@Query("SELECT u FROM ExpenseType u WHERE u.name LIKE CONCAT('%',:name,'%')")
	List<ExpenseType> findByName(@Param("name") String name);
}