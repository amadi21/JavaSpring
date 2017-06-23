package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Record;

public interface RecordDao extends CrudRepository<Record, Long> {
	
	

}
