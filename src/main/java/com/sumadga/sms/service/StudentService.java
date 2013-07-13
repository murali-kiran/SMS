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

import com.sumadga.sms.dao.StudentDao;
import com.sumadga.sms.dto.Address;
import com.sumadga.sms.dto.Parent;
import com.sumadga.sms.dto.Student;
import com.sumadga.sms.model.StudentForm;
import com.sumadga.sms.utils.CommonUtils;

@Service
public class StudentService {
	
	private static final Logger logger = Logger.getLogger(StudentService.class);
	
	@Autowired
	private StudentDao studentDao;
	
/*
 
 public boolean saveStudentDetails(StudentForm studentForm){
		
		logger.info("Saving Student Info from Student Form");
		
		try {
			
		Student student = new Student();
		
		Parent parent = new Parent();
		parent.setFatherName(studentForm.getFatherName());
		parent.setFatherDesignation(studentForm.getFatherDesignation());
		parent.setMotherName(studentForm.getMotherName());
		parent.setMotherDesignation(studentForm.getFatherDesignation());
		parent.setGaurdian(studentForm.getGaurdian());
		parent.setCreatedTime(new Date());
		parent.setModifiedTime(new Date());
		
		student.setParent(parent);
		
		Address permanentAddress = new Address();
		permanentAddress.setAddress1(studentForm.getAddress1());
		permanentAddress.setDistrict(studentForm.getDistrict1());
		permanentAddress.setState(studentForm.getState1());
		permanentAddress.setPincode(studentForm.getPincode1());
						
		student.setAddress(permanentAddress);
		
		Address temporaryAddress = new Address();
		temporaryAddress.setAddress2(studentForm.getAddress2());
		temporaryAddress.setDistrict(studentForm.getDistrict2());
		temporaryAddress.setState(studentForm.getState2());
		temporaryAddress.setPincode(studentForm.getPincode2());
		
		
		student.setName(studentForm.getName());
		student.setSurName(studentForm.getSurName());
		student.setDateOfBirth(CommonUtils.getStringToDate(studentForm.getDateOfBirth()));
		student.setJoiningDate(CommonUtils.getStringToDate(studentForm.getJoiningDate()));
		student.setCreatedTime(new Date());
		student.setModifiedTime(new Date());
		
		student.setIsPhysicallyChallenged(studentForm.getIsPhysicallyChallenged() ? (byte)1 : 0);
		
		List<Student> studentList= new ArrayList<Student>();
		studentList.add(student);
		permanentAddress.setStudents(studentList);
		
		parent.setAddress(permanentAddress);
		parent.setStudents(studentList);
		
		studentDao.save(student);
		
		} catch (DataAccessException e) {
			logger.info("The Exception in saveStudentDetails : ",e);
			return false;
		} catch (Exception e) {
			logger.info("The Exception in saveStudentDetails : ",e);
			return false;
		}
		
		return true;
	}
	
*/

	
	
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DataAccessException.class)
	public boolean saveStudentDetails(Map<String, String> requestMap){
		
		logger.info("Saving Student Info from Student Form");
		
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
		
		} catch (DataAccessException e) {
			logger.info("The Exception in saveStudentDetails : ",e);
			return false;
		} catch (Exception e) {
			logger.info("The Exception in saveStudentDetails : ",e);
			return false;
		}
		
		return true;
	}
	
	public boolean saveStudentSpecificDetails(StudentForm studentForm){
		
	logger.info("Before Saving Student Specific Details");
		
		try {
			
		Student student = new Student();
		
		Parent parent = new Parent();
		parent.setFatherName(" ");
		parent.setFatherDesignation(" ");
		parent.setMotherName(" ");
		parent.setMotherDesignation(" ");
		parent.setGaurdian(" ");
		parent.setCreatedTime(new Date());
		parent.setModifiedTime(new Date());
		
/*		parent.setCreatedTime(CommonUtils.getStringToDate(studentForm.getJoiningDate()));
		parent.setModifiedTime(CommonUtils.getStringToDate(studentForm.getJoiningDate())); 	
*/		
		
		student.setParent(parent);
		
		Address permanentAddress = new Address();
		permanentAddress.setAddress1(" ");
		permanentAddress.setDistrict(" ");
		permanentAddress.setState(" ");
		permanentAddress.setPincode(" ");
		
		student.setAddress(permanentAddress);
		
		System.out.println(studentForm.getName()+" --- "+studentForm.getSurName());
		student.setName(studentForm.getName()); 
		student.setSurName(studentForm.getSurName());
		student.setDescription(studentForm.getDescription());
		
	/*	student.setDateOfBirth(CommonUtils.getStringToDate(studentForm.getDateOfBirth()));
		student.setJoiningDate(CommonUtils.getStringToDate(studentForm.getJoiningDate()));*/
		
		student.setDateOfBirth(new Date());
		student.setJoiningDate(new Date());
		student.setCreatedTime(new Date());
		student.setModifiedTime(new Date());
		student.setIsPhysicallyChallenged(studentForm.getIsPhysicallyChallenged() ? (byte)1 : 0);//
		
		List<Student> studentList= new ArrayList<Student>();
		studentList.add(student);
		permanentAddress.setStudents(studentList);
		
		parent.setAddress(permanentAddress);
		parent.setStudents(studentList);
		
//		studentDao = (StudentDao)getContext().getBean("studentDao");
		studentDao.save(student);
		
		} catch (DataAccessException e) {
			logger.info("The Exception in saveStudentDetails : ",e);
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("The Exception in saveStudentDetails : ",e);
			return false;
		}
						
		return true;				
		
	}
	

}
