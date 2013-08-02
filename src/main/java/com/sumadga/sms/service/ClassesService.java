package com.sumadga.sms.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sumadga.sms.dao.StudentClassDao;
import com.sumadga.sms.dto.Address;
import com.sumadga.sms.dto.Parent;
import com.sumadga.sms.dto.Student;
import com.sumadga.sms.dto.StudentClass;
import com.sumadga.sms.utils.CommonUtils;

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
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DataAccessException.class)
	public boolean saveNewClass(Map<String,String> requestMap){
		
		try {
			
			Student student = new Student();
			
			Parent parent = new Parent();
			parent.setFatherName(requestMap.get("fatherName"));
			parent.setFatherDesignation(requestMap.get("fatherDesignation"));
			parent.setMotherName(requestMap.get("motherName")); // motherDesignation
			parent.setMotherDesignation(requestMap.get("motherDesignation"));
			parent.setGaurdian(requestMap.get("gaurdian"));
			parent.setCreatedTime(new Date());
			parent.setModifiedTime(new Date());
			
			student.setParent(parent);
			
			Address permanentAddress = new Address();
			permanentAddress.setAddress1(requestMap.get("Addr1Hno"));
			permanentAddress.setDistrict(requestMap.get("district1"));
			permanentAddress.setState(requestMap.get("state1"));
			permanentAddress.setPincode(requestMap.get("pincode1"));
							
			student.setAddress(permanentAddress);
			
		/*	Address temporaryAddress = new Address();
			temporaryAddress.setAddress2(studentForm.getAddress2());
			temporaryAddress.setDistrict(studentForm.getDistrict2());
			temporaryAddress.setState(studentForm.getState2());
			temporaryAddress.setPincode(studentForm.getPincode2());
			*/
			
			student.setName(requestMap.get("name"));
			student.setSurName(requestMap.get("surName"));
			student.setDateOfBirth(CommonUtils.getStringToDate(requestMap.get("dateOfBirth")));
			student.setJoiningDate(CommonUtils.getStringToDate(requestMap.get("joiningDate")));
			student.setCreatedTime(new Date());
			student.setModifiedTime(new Date());
			
			student.setIsPhysicallyChallenged(Byte.parseByte(requestMap.get("isPhysicallyChallenged")));
			
			List<Student> studentList= new ArrayList<Student>();
			studentList.add(student);
			permanentAddress.setStudents(studentList);
			
			parent.setAddress(permanentAddress);
			parent.setStudents(studentList);
			
			studentDao.save(student);
			
		}catch (DataAccessException e) {
			logger.info("The Exception in saveStudentDetails : ",e);
			return false;
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	

}
