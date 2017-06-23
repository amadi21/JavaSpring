package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.RecordDao;
import com.example.demo.model.Record;

@RestController
@RequestMapping("/record")
public class RecordController {
	
	@Autowired
	private RecordDao recDao;
	
	@CrossOrigin
	@RequestMapping(value = "/get/all", method = RequestMethod.GET)
	public Iterable<Record> getAllRecords() {
		return recDao.findAll();
	}
	
	@CrossOrigin
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addRecord(@RequestBody Record newRec) {
		try {
			recDao.save(newRec);
			return "OK";
		} catch (Exception e) {
			return "nie poszedlo, poniewaz " + e;
		}
	}

}
