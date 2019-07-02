package com.example.demo.data;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.PaymentType;

public interface PaymentTypeRepository extends CrudRepository<PaymentType, Long> {
	@Query("SELECT u FROM PaymentType u WHERE u.name LIKE CONCAT('%',:name,'%')")
	List<PaymentType> findByName(@Param("name") String name);
}