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
import com.sumadga.sms.dao.TeachingStaffDao;
import com.sumadga.sms.dao.TeachingStaffSubjectDao;
import com.sumadga.sms.dto.Designations;
import com.sumadga.sms.dto.Staff;
import com.sumadga.sms.dto.Subject;
import com.sumadga.sms.dto.TeachingStaff;
import com.sumadga.sms.dto.TeachingStaffSubject;
import com.sumadga.sms.model.GenericBean;
import com.sumadga.sms.utils.CommonUtils;

@Service
public class HomeService {
	
	@Autowired
	private DesignationsDao designationsDao;	
	@Autowired
	private StaffDao staffDao;
	@Autowired
	private SubjectDao subjectDao;
	@Autowired
	private TeachingStaffDao teachingStaffDao;
	@Autowired
	private TeachingStaffSubjectDao teachingStaffSubjectDao;
	
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

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DataAccessException.class)
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
			
			if(designation.getIsTeaching() == 1){
				
		    	staff =	staffDao.findStaffDetailsByProperties(staff.getName(),staff.getJoiningDate(),staff.getIsTeachinfStaff());
				TeachingStaff teachingStaff = new TeachingStaff();
				teachingStaff.setStaff(staff);
				teachingStaffDao.save(teachingStaff);
			}
			
		} catch (Exception e) {
			logger.error("Find failed", e);
			
		}
		
    		return false;
	}
	
	public  List<Subject> getAllSubjects(){
		try {
		List<Subject> subjects =	subjectDao.findAll();
		return subjects;
		} catch (Exception e) {
			logger.error("All subjects not retrived", e);
			return null;
		}
	}
	
	public  List<GenericBean> getTeachingStaff(){
		
		try {
		List<GenericBean> staffs = teachingStaffDao.findAllTeachingStaffByNativeQuery();
		return staffs;
		} catch (Exception e) {
			logger.error("Teaching staff details are not retrived", e);
			return null;
		}
	}
	
	public List<Integer> getTeachingSubjects(int teacherStaffId){
		try {
			TeachingStaff teachingStaff = new TeachingStaff();
			teachingStaff.setTeachingStaffId(teacherStaffId);
			
		//	teachingStaff.setTeachingStaffId(teachingStaffId);
			List<TeachingStaffSubject> teachingStaffSubjects = teachingStaffSubjectDao.findByProperty("teachingStaff",teachingStaff);
			List<Integer> teachingStaffIds = new ArrayList<Integer>();
			for(TeachingStaffSubject teachingStaffSubject : teachingStaffSubjects){
				teachingStaffIds.add(teachingStaffSubject.getTeachingStaffSubjectId());
			}
			return teachingStaffIds;
			
			} catch (Exception e) {
				logger.error("Teaching staff Subjects details are not retrived", e);
				return null;
			}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DataAccessException.class)
	public Boolean saveSubjectsOfTeacher(Map<String, String> requestMap) {
		try {
			
			// [null, null, null, teacherList=1, null, null, subject=1,2, null, null, null, null, null, null, null, null, null]
			Integer teachingStaffId = Integer.parseInt(requestMap.get("teacherList"));
			String [] subjectsId =  requestMap.get("subject").toString().split(",");
			
			for(String subjectId : subjectsId){
				
				TeachingStaff teachingStaff = new TeachingStaff();
				teachingStaff.setTeachingStaffId(teachingStaffId);
				
				Subject subject = new Subject();
				subject.setSubjectId(Integer.parseInt(subjectId));
				
				if(!teachingStaffSubjectDao.isSubjectAndTeacherAlreadyExist(teachingStaff,subject)){
					TeachingStaffSubject teachingStaffSubject = new TeachingStaffSubject();
					teachingStaffSubject.setSubject(subject);
					teachingStaffSubject.setTeachingStaff(teachingStaff);
					
					teachingStaffSubjectDao.save(teachingStaffSubject);
				}
			}
			
			return true;
		} catch (Exception e) {
			logger.error("Teacher and Subjects Mappinh Failed", e);
			return null;
		}
	}
}
