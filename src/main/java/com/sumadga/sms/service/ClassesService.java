package com.sumadga.sms.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import com.sumadga.sms.dao.StudentClassDao;
import com.sumadga.sms.dto.StudentClass;

@Service
public class ClassesService {
	
	private static final Logger logger = Logger.getLogger(ClassesService.class);
	
	@Autowired
	private StudentClassDao classesDao;
	
	public List<StudentClass> getClassInfo() throws DataAccessException{
		
		logger.info("Retrieve all classes ");
		
		try {
		
		return classesDao.findAll();
		
		} catch (Exception e) {
			return null;
		}
	}

}
