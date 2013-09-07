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

import com.sumadga.sms.dao.ClassSectionDao;
import com.sumadga.sms.dao.DesignationsDao;
import com.sumadga.sms.dao.ExamTimeTableDao;
import com.sumadga.sms.dao.ExamTypeDao;
import com.sumadga.sms.dao.SectionDao;
import com.sumadga.sms.dao.StaffDao;
import com.sumadga.sms.dao.StudentClassDao;
import com.sumadga.sms.dao.SubjectDao;
import com.sumadga.sms.dao.TeachingStaffDao;
import com.sumadga.sms.dao.TeachingStaffSubjectDao;
import com.sumadga.sms.dto.ClassSection;
import com.sumadga.sms.dto.Designations;
import com.sumadga.sms.dto.ExamTimeTable;
import com.sumadga.sms.dto.ExamType;
import com.sumadga.sms.dto.Section;
import com.sumadga.sms.dto.Staff;
import com.sumadga.sms.dto.StudentClass;
import com.sumadga.sms.dto.Subject;
import com.sumadga.sms.dto.TeachingStaff;
import com.sumadga.sms.dto.TeachingStaffSubject;
import com.sumadga.sms.model.ExamTimeTableData;
import com.sumadga.sms.model.GenericBean;
import com.sumadga.sms.model.JqGridInfo;
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
	@Autowired
	private ExamTypeDao examTypeDao;
	@Autowired
	private StudentClassDao studentClassDao;
	@Autowired
	private ExamTimeTableDao examTimeTableDao;
	@Autowired
	private SectionDao sectionDao;
	@Autowired
	private ClassSectionDao classSectionDao;
	
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
	
	public boolean  isAlreadyExamTypeExist(Map<String, String> requestMap){
		
		String examNameStr = requestMap.get("examNames").trim();
		
		String [] examNames = examNameStr.split(",");
		boolean isExamTypeAlreadyExist = false;
		
		for(String examName : examNames){
			List<ExamType> examNameList = examTypeDao.findByProperty("examTypeName",examName);
			if(examNameList.size() > 0){
				isExamTypeAlreadyExist = true;
				break;
			}
		}
		
		return isExamTypeAlreadyExist;
	}
	
	
public boolean  isAlreadyClassExist(Map<String, String> requestMap){
		
		String classNameStr = requestMap.get("classNames").trim();
		
		String [] classNames = classNameStr.split(",");
		boolean isClassAlreadyExist = false;
		
		for(String className : classNames){
			List<StudentClass> classList = studentClassDao.findByProperty("className",className);
			if(classList.size() > 0){
				isClassAlreadyExist = true;
				break;
			}
		}
		
		return isClassAlreadyExist;
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
	
	
	public List<Section> getAllSections(){
	  return sectionDao.findAll();
	}
	
	
	
	public List<Integer> getTeachingSubjects(int teacherStaffId){
		try {
			TeachingStaff teachingStaff = new TeachingStaff();
			teachingStaff.setTeachingStaffId(teacherStaffId);
			
		//	teachingStaff.setTeachingStaffId(teachingStaffId);
			List<TeachingStaffSubject> teachingStaffSubjects = teachingStaffSubjectDao.findByProperty("teachingStaff",teachingStaff);
			List<Integer> teachingStaffIds = new ArrayList<Integer>();
			for(TeachingStaffSubject teachingStaffSubject : teachingStaffSubjects){
				teachingStaffIds.add(teachingStaffSubject.getSubject().getSubjectId());
			}
			return teachingStaffIds;
			
			} catch (Exception e) {
				logger.error("Teaching staff Subjects details are not retrived", e);
				return null;
			}
	}
	
	
	public List<Integer> getClassSubjects(int classId){
		try {
			logger.info("Before of getting sections of class");
			StudentClass studentClass = new StudentClass();
			studentClass.setClassId(classId);
			
			List<ClassSection> classSections = classSectionDao.findByProperty("studentClass",studentClass);
			List<Integer> sectionIds = new ArrayList<Integer>();
			for(ClassSection classSection : classSections){
				sectionIds.add(classSection.getSection().getSectionId());
			}
			return sectionIds;
			
			} catch (Exception e) {
				logger.error("Class Sections details are not retrived", e);
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
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DataAccessException.class)
	public Boolean saveSectionsOfClass(Map<String, String> requestMap) {
		try {
			
			logger.info("Before saving the sections of the class ");
			Integer classId = Integer.parseInt(requestMap.get("classList"));
			String [] sectionsId =  requestMap.get("section").toString().split(",");
			
			StudentClass studentClass = new StudentClass();
			studentClass.setClassId(classId);
			
			for(String sectionId : sectionsId){
				
				Section section = new Section();
				section.setSectionId(Integer.parseInt(sectionId));
				
				if(!classSectionDao.isSectionAndClassAlreadyExist(studentClass,section)){
					ClassSection classSection = new ClassSection();
					classSection.setSection(section);
					classSection.setStudentClass(studentClass);
					classSectionDao.save(classSection);
				}
				
			}
			
			return true;
		} catch (Exception e) {
			logger.error("Class and section mapping Failed", e);
			return null;
		}
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DataAccessException.class)
	public boolean saveExamTypes(Map<String, String> requestMap){
		
		String [] examTypeNames = requestMap.get("examType").split(",");
		try {
	
		for(String examTypeName : examTypeNames){
			ExamType examType = new ExamType();
			examType.setExamTypeName(examTypeName.toLowerCase());
			examTypeDao.save(examType);
		}
		
		return true;
		} catch (Exception e) {
			return false;
		}
		
		
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DataAccessException.class)
	public boolean saveClassInfo(Map<String, String> requestMap){
		
		String [] classNames = requestMap.get("className").split(",");
		try {
	
		for(String className : classNames){
			StudentClass studentClass = new StudentClass();
			studentClass.setClassName(className.toLowerCase());
			studentClassDao.save(studentClass);
		}
		
		return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	public List<StudentClass> getAllClasses() {
		List<StudentClass> studentClasses =	studentClassDao.findAll();
		return studentClasses;
	}

	public void saveExamTimeTable(Map<String, String> requestMap) {
		
	String classId    =	requestMap.get("classList");
	String subjectId  =	requestMap.get("subjectList");
	String teacherId  =	requestMap.get("teacherList");
	String doe        =	requestMap.get("dateOfExam");
	String startTime  =	requestMap.get("startTime");
	String endTime    =	requestMap.get("endTime");
	String examTypeId =	requestMap.get("examTypeList");
	int  marks      = Integer.parseInt(requestMap.get("maxMarks"));
	
	
    ExamTimeTable examTimeTable = new ExamTimeTable();
    examTimeTable.setExamStartTime(CommonUtils.StringToTime(startTime));
    examTimeTable.setExamEndTime(CommonUtils.StringToTime(endTime));
    
    StudentClass studentClass = new StudentClass();
    studentClass.setClassId(Integer.parseInt(classId));
    examTimeTable.setStudentClass(studentClass);
    
    examTimeTable.setTeachingStaffId(Integer.parseInt(teacherId));
    
    examTimeTable.setExamDate(CommonUtils.getStringToDate(doe));
    
    Subject subject = new Subject();
    subject.setSubjectId(Integer.parseInt(subjectId));
    examTimeTable.setSubject(subject);
    
    ExamType examType = new ExamType();
    examType.setExamTypeId(Integer.parseInt(examTypeId));
    examTimeTable.setExamType(examType);
    examTimeTable.setMaximumMarks(marks);
    
    examTimeTableDao.save(examTimeTable);
    
    
	}

	public List<ExamType> getAllExamTypes() {
		List<ExamType> examTypes =	examTypeDao.findAll();
		return examTypes;
	}

	public List<ExamTimeTable> getExamTimeTable() {
		List<ExamTimeTable> examTimeTables = examTimeTableDao.findAll();
		return examTimeTables;
	}

	public JqGridInfo<ExamTimeTableData> getJqGridDataForExamTimeTable() {
		
		int totalNumberOfPages = 1;
	    int currentPageNumber = 1;
	    
	    List<ExamTimeTable> examTimeTables  = examTimeTableDao.findAll();
	    int totalNumberOfRecords = examTimeTables.size();
		
		List<ExamTimeTableData> rows = new ArrayList<ExamTimeTableData>();
		
		if(examTimeTables!=null && examTimeTables.size() > 0){
			for(ExamTimeTable examTimeTable : examTimeTables){
				
				StudentClass studentClass    =   examTimeTable.getStudentClass();
				ExamType     examType        =   examTimeTable.getExamType();
				Date         examDate        =   examTimeTable.getExamDate();
				String       startTime       =   CommonUtils.convertTime_ToSpecific_TimeFormat(examTimeTable.getExamStartTime(),"hh:mm a");
				String       endTime         =   CommonUtils.convertTime_ToSpecific_TimeFormat(examTimeTable.getExamEndTime(),"hh:mm a");
				Integer      maxMarks        =   examTimeTable.getMaximumMarks();
				
				Subject subject   = examTimeTable.getSubject();
				
				ExamTimeTableData tableData = new ExamTimeTableData();
				
				tableData.setClassName(studentClass.getClassName());
				tableData.setSubjectName(subject.getSubjectName());
				tableData.setTotal(maxMarks.toString());
				tableData.setStartTime(startTime);
				tableData.setEndTime(endTime);
				tableData.setExamType(examType.getExamTypeName());
				tableData.setExamDate(CommonUtils.convertDate_ToSpecific_DateFormat(examDate,"dd-MMM-yyyy"));
				
				rows.add(tableData);
			}
		}
		
		JqGridInfo<ExamTimeTableData> jqGridInfo = new JqGridInfo<ExamTimeTableData>(totalNumberOfPages, currentPageNumber, totalNumberOfRecords, rows);
		
		System.out.println(jqGridInfo.getJsonString());
		
		return jqGridInfo;
	}

	public boolean isAlreadyExamTimeTableExist(Map<String, String> requestMap) {
		
	List<Integer> recordCounts  = examTimeTableDao.findByProperties(requestMap);
	if(recordCounts.size() > 0){
		logger.info("Same Exam Time entry already exist ");
		return true;
	}
		return false;
	}

	public TeachingStaff getTeachingStaffDetails(Map<String, String> requestMap) {
		Long teachingStaffId = Long.parseLong(requestMap.get("teacherList"));
		TeachingStaff teachingStaff = teachingStaffDao.findById(teachingStaffId);
		return teachingStaff;
	}

	public StudentClass getClassDetails(Integer classId) {
		StudentClass studentClass = studentClassDao.findById(classId);
		return studentClass;
	}
	
}
