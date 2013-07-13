package com.sumadga.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.sumadga.sms.dao.AddressDao;
import com.sumadga.sms.dao.StudentDao;
import com.sumadga.sms.dto.Address;
import com.sumadga.sms.dto.Parent;
import com.sumadga.sms.dto.Student;
import com.sumadga.sms.utils.CommonUtils;

public class Sample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ClassPathXmlApplicationContext  applicationContext=new ClassPathXmlApplicationContext("/test-applicationcontext.xml");

		/*AddressDao addressDao=(AddressDao)applicationContext.getBean("addressDao");
		Address address=new Address();
		
		address.setAddress1("1");
		address.setAddress2("2");
		address.setAddress3("3");
		address.setDistrict("hyd");
		address.setState("ap");
		address.setPincode("500006");
		
		addressDao.save(address);*/
		
		StudentDao studentDao = (StudentDao)applicationContext.getBean("studentDao");
		
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
			
			
			student.setParent(parent);
			
			Address permanentAddress = new Address();
			permanentAddress.setAddress1(" ");
			permanentAddress.setDistrict(" ");
			permanentAddress.setState(" ");
			permanentAddress.setPincode(" ");
			
			student.setAddress(permanentAddress);
			
			
			student.setName("xyz");
			student.setSurName("abc");
			
		/*	student.setDateOfBirth(CommonUtils.getStringToDate(studentForm.getDateOfBirth()));
			student.setJoiningDate(CommonUtils.getStringToDate(studentForm.getJoiningDate()));*/
			
			student.setDateOfBirth(new Date());
			student.setJoiningDate(new Date());
			student.setCreatedTime(new Date());
			student.setModifiedTime(new Date());
			student.setIsPhysicallyChallenged((byte)1);
			
			List<Student> studentList= new ArrayList<Student>();
			studentList.add(student);
			permanentAddress.setStudents(studentList);
			
			parent.setAddress(permanentAddress);
			parent.setStudents(studentList);
			
			studentDao.save(student);
		
		} catch (DataAccessException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
