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

import com.sumadga.sms.dao.DesignationsDao;
import com.sumadga.sms.dao.StaffDao;
import com.sumadga.sms.dao.SubjectDao;
import com.sumadga.sms.dto.Designations;
import com.sumadga.sms.dto.Staff;
import com.sumadga.sms.dto.Subject;
import com.sumadga.sms.utils.CommonUtils;
import com.sumadga.sms.utils.Utils;

@Service
public class HomeService {
	
	@Autowired
	private DesignationsDao designationsDao;	
	@Autowired
	private StaffDao staffDao;
	@Autowired
	private SubjectDao subjectDao;
	
	private static final Logger logger = Logger.getLogger(HomeService.class);
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DataAccessException.class)
	public boolean saveDesignations(Map<String, String> requestMap){
		
		
		Designations designations = new Designations();
		designations.setDesignation(requestMap.get("designationName"));
		designations.setIsTeaching(Byte.parseByte(requestMap.get("designationType")));
		designations.setCreatedTime(new Date());
		designations.setModifiedTime(new Date());
		
		designationsDao.save(designations);
		
		return false;
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DataAccessException.class)
	public boolean saveSubject(Map<String, String> requestMap){
		
		String [] subjects = requestMap.get("subject").split(",");
		try {
	
		for(String subjectName : subjects){
			Subject subject = new Subject();
			subject.setSubjectName(subjectName.toLowerCase());
			subjectDao.save(subject);
		}
		
		return true;
		} catch (Exception e) {
			return false;
		}
		
		
	}
	
	public boolean  isAlreadyDesignationExist(Map<String, String> requestMap){
		
		String subjectStr = requestMap.get("subjects").trim();
		
		String [] subjects = subjectStr.split(",");
		boolean isSubjectAlreadyExist = false;
		
		for(String subject : subjects){
			List<Subject> subjectList = subjectDao.findByProperty("subjectName",subject);
			if(subjectList.size() > 0){
				isSubjectAlreadyExist = true;
				break;
			}
		}
		
		return isSubjectAlreadyExist;
	}
		
	
	public boolean  isAlreadySubjectExist(Map<String, String> requestMap){
		List<Designations> designations = designationsDao.isDesignationExist(requestMap.get("designationName"),Byte.parseByte(requestMap.get("designationType")));
		
		if(designations.size() > 0)
			return true;
		else
			return false;
	}

	public List<Designations> getAllDesignations() {
		List<Designations> designations =	designationsDao.findAll();
		return designations;
	}

	public boolean saveEmpDetails(Map<String, String> requestMap) {
		try {
			
		
			Designations designation =	designationsDao.findById(Integer.parseInt(requestMap.get("designationType")));
		
			Staff staff = new Staff();
			staff.setName(requestMap.get("empName"));
			
			staff.setJoiningDate(CommonUtils.getStringToDate(requestMap.get("joiningDate")));
			staff.setIsTeachinfStaff(designation.getIsTeaching()+"");
			
			List<Staff> staffs = new ArrayList<Staff>();
			designation.setStaff(staffs);
			staff.setDesignations(designation);
			
			staffDao.save(staff); 
			
		} catch (Exception e) {
			logger.error("find failed", e);
			
		}
		
    		return false;
	}
}
