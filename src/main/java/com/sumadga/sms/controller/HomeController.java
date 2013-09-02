package com.sumadga.sms.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sumadga.sms.dao.SubjectDao;
import com.sumadga.sms.dto.Designations;
import com.sumadga.sms.dto.ExamType;
import com.sumadga.sms.dto.StudentClass;
import com.sumadga.sms.dto.Subject;
import com.sumadga.sms.model.ClassForm;
import com.sumadga.sms.model.ExamTimeTableData;
import com.sumadga.sms.model.ExamTimeTableGrid;
import com.sumadga.sms.model.GenericBean;
import com.sumadga.sms.model.JqGridInfo;
import com.sumadga.sms.reponses.GenericJsonResponse;
import com.sumadga.sms.reponses.SubjectsOfTeacherResponse;
import com.sumadga.sms.service.ClassesService;
import com.sumadga.sms.service.HomeService;
import com.sumadga.sms.utils.RequestUtil;
import com.sumadga.sms.validator.ValidationProperties;

@Controller
public class HomeController {
	
	@Autowired
	private HomeService homeService;
	
	@Autowired
	private ClassesService classesService;
	
	@Autowired
	private ValidationProperties properties;
	
	@Autowired
	private SubjectDao  subjectDao;
	
	
	@RequestMapping(value="/",method = RequestMethod.GET)
	public String welcomePage(Model model){
		return "forward:/login";
	}
	
	@RequestMapping(value="/login",method = RequestMethod.GET)
	public String login(Model model){
		return "login";
	}
	
	@RequestMapping(value="/classesInfo",method = RequestMethod.GET)
	public String classesInfo(Model model){
		
		List<StudentClass> classes = classesService.getClassInfo();		
		model.addAttribute("classes", classes);
		model.addAttribute("classForm", new ClassForm());
		return "manageClasses";
	}
	
	@RequestMapping(value="/homePage",method = RequestMethod.GET)
	public String home(Model model){
		return "homePage";
	}
	
	
	@RequestMapping(value="/createNewClass",method = RequestMethod.GET)
	public String createNewClass(Model model){
		return "createNewClass";
	}
	
	@RequestMapping(value="/createNewSubject",method = RequestMethod.GET)
	public String createNewSubject(Model model){
		return "createNewSubject";
	}
	
	@RequestMapping(value="/createNewEmployee",method = RequestMethod.GET)
	public String createNewEmployee(Model model){
		return "createNewEmployee";
	}
	
	@RequestMapping(value="/createDesignations",method = RequestMethod.GET)
	public String createDesignations6(Model model){
		return "createDesignations";
	}
	
	@RequestMapping(value="/createStaff",method = RequestMethod.GET)
	public String createStaff(Model model){
	List<Designations> designations = homeService.getAllDesignations();
	model.addAttribute("designations", designations);
	return "createStaff";
	}
	
	
	
	@RequestMapping(value="/saveNewStaff",method = RequestMethod.POST)
	public String saveNewStaff(Model model,HttpServletRequest request){
	Map<String,String> requestMap =RequestUtil.INSTANCE.dumpRequestScope(request);
	homeService.saveEmpDetails(requestMap);
//	model.addAttribute("designations",);
	return "createStaff";
	}
	
	@RequestMapping(value="/saveNewDesignation",method = RequestMethod.POST)
	public String saveNewDesignation(Model model,HttpServletRequest request){
		
		Map<String,String> requestMap =RequestUtil.INSTANCE.dumpRequestScope(request);
		homeService.saveDesignations(requestMap);
		
		return "createDesignations";
	}
	
	@RequestMapping(value="/alreadyDesignationExist",method = RequestMethod.GET)
	public @ResponseBody GenericJsonResponse alreadyDesignationExist(Model model,HttpServletRequest request){
		
		Map<String,String> requestMap =RequestUtil.INSTANCE.dumpRequestScope(request);
		GenericJsonResponse response = new GenericJsonResponse();
		if(homeService.isAlreadyDesignationExist(requestMap)){
			response.setStatus(true);
			response.setMessage("Director already exist");
		}else{
			response.setStatus(false);
		}
		
		return response;
	}
	
	
	@RequestMapping(value="/alreadySubjectExist",method = RequestMethod.GET)
	public @ResponseBody GenericJsonResponse alreadySubjectExist(Model model,HttpServletRequest request){
		
		Map<String,String> requestMap =RequestUtil.INSTANCE.dumpRequestScope(request);
		GenericJsonResponse response = new GenericJsonResponse();
		if(homeService.isAlreadyDesignationExist(requestMap)){
			response.setStatus(true);
			response.setMessage(properties.getSubjectAlreadyExist());
		}else{
			response.setStatus(false);
		}
		
		return response;
	}
	
	@RequestMapping(value="/saveNewSubjects",method = RequestMethod.POST)
	public String saveNewSubject(Model model,HttpServletRequest request){
		
		Map<String,String> requestMap =RequestUtil.INSTANCE.dumpRequestScope(request);
		homeService.saveSubject(requestMap);
		
		return "createNewSubject";
	}
	
	@RequestMapping(value="/showTeacherAndSubjectMapping",method = RequestMethod.GET)
	public String showTeacherAndSubjectMapping(Model model){
		
		List<Subject> subjects = homeService.getAllSubjects();
		List<GenericBean> teachers   = homeService.getTeachingStaff();
		
		model.addAttribute("teachers", teachers);
		model.addAttribute("subjects",subjects);
		
		return "teacherAndSubjectMapping";
	}
	
	
	@RequestMapping(value="/getSubjectsOfTeacher",method = RequestMethod.GET)
	public @ResponseBody SubjectsOfTeacherResponse getSubjectsOfTeacher(Model model,HttpServletRequest request){
		
		SubjectsOfTeacherResponse response = new SubjectsOfTeacherResponse();
		Map<String,String> requestMap =RequestUtil.INSTANCE.dumpRequestScope(request);
		
		List<Integer> teachingStaffSubjectIds = homeService.getTeachingSubjects(Integer.parseInt(requestMap.get("teacherId")));
		
		response.setTeachingStaffSubjectIds(teachingStaffSubjectIds);
		response.setStatus(true);
		return response;
	}
	
	
	
	@RequestMapping(value="/saveTeacherAndSubjectMapping",method = RequestMethod.POST)
	public String saveTeacherAndSubjectMapping(Model model,HttpServletRequest request){
		
		Map<String,String> requestMap =RequestUtil.INSTANCE.dumpRequestScope(request);
		homeService.saveSubjectsOfTeacher(requestMap);
		
		return "teacherAndSubjectMapping";
	}
	
	
/*	@RequestMapping(value = "/saveNewClass", method = RequestMethod.POST)
	public String  saveStudentDetails(Model model,HttpServletRequest request)
	{
		
		Map<String,String> requestMap = RequestUtil.INSTANCE.dumpRequestScope(request);
						
		classesService.saveStudentDetails(requestMap);
				
		return "";
	}*/
	
	
	
	/*@RequestMapping(value="/getSectionDetailsOfClass",method = RequestMethod.GET)
	public String classesInfo(Model model){
		
		List<StudentClass> classes = classesService.getClassInfo();		
		model.addAttribute("classes", classes);
//		model.addAttribute("classForm", new ClassForm());
		return "classInfo";
	}*/
	
	@RequestMapping(value="/saveClassDetails",method = RequestMethod.POST)
	public String saveClassDetails(Model model,HttpServletRequest request){
		
		return "classInfo";
	}
	
	// Exam Type
	@RequestMapping(value="/createExamType",method = RequestMethod.GET)
	public String createExamType(Model model){
		return "createExamType";
	}
	
	@RequestMapping(value="/saveExamType",method = RequestMethod.POST)
	public String saveExamType(Model model,HttpServletRequest request){
		Map<String,String> requestMap =RequestUtil.INSTANCE.dumpRequestScope(request);
		if(homeService.saveExamTypes(requestMap)){
			model.addAttribute("successMsg", properties.getExamTypeSaveSuccess());
		}
		return "createExamType";
	}
	
	@RequestMapping(value="/alreadyExamTypeExist",method = RequestMethod.GET)
	public @ResponseBody GenericJsonResponse alreadyExamTypeExist(Model model,HttpServletRequest request){
		
		Map<String,String> requestMap =RequestUtil.INSTANCE.dumpRequestScope(request);
		GenericJsonResponse response = new GenericJsonResponse();
		if(homeService.isAlreadyExamTypeExist(requestMap)){
			response.setStatus(true);
			response.setMessage(properties.getExamTypeAlreadyExist());
		}else{
			response.setStatus(false);
		}
		
		return response;
	}
	
	// New Class
	
	@RequestMapping(value="/showNewClass",method = RequestMethod.GET)
	public String showNewClass(Model model){
		return "showNewClass";
	}
	
	@RequestMapping(value="/saveClassInfo",method = RequestMethod.POST)
	public String saveClassInfo(Model model,HttpServletRequest request){
		Map<String,String> requestMap =RequestUtil.INSTANCE.dumpRequestScope(request);
		if(homeService.saveClassInfo(requestMap)){
			model.addAttribute("successMsg", properties.getExamTypeSaveSuccess());
		}
		return "createExamType";
	}
	
	@RequestMapping(value="/alreadyClassExist",method = RequestMethod.GET)
	public @ResponseBody GenericJsonResponse alreadyClassExist(Model model,HttpServletRequest request){
		
		Map<String,String> requestMap =RequestUtil.INSTANCE.dumpRequestScope(request);
		GenericJsonResponse response = new GenericJsonResponse();
		if(homeService.isAlreadyClassExist(requestMap)){
			response.setStatus(true);
			response.setMessage(properties.getExamTypeAlreadyExist());
		}else{
			response.setStatus(false);
		}
		
		return response;
	}
	
	
	// ExamTimeTable
	@RequestMapping(value="/createExamTimeTable",method = RequestMethod.GET)
	public String createExamTimeTable(Model model){
		
		List<Subject> subjects = homeService.getAllSubjects();
		List<GenericBean> teachers   = homeService.getTeachingStaff();
		List<StudentClass> studentClasses = homeService.getAllClasses();
		List<ExamType> examTypes = homeService.getAllExamTypes();
		
		model.addAttribute("examTypes", examTypes);
		model.addAttribute("teachers", teachers);
		model.addAttribute("subjects",subjects);
		model.addAttribute("classes", studentClasses);
		
		return "createExamTimeTable";
	}
	
	@RequestMapping(value="/alreadyExamTimeTableExist",method = RequestMethod.GET)
	public @ResponseBody GenericJsonResponse alreadyExamTimeTableExist(Model model,HttpServletRequest request){
		
		Map<String,String> requestMap =RequestUtil.INSTANCE.dumpRequestScope(request);
		GenericJsonResponse response = new GenericJsonResponse();
		if(homeService.isAlreadyExamTimeTableExist(requestMap)){
			response.setStatus(true);
			response.setMessage(properties.getExamTimeTableExist());
		}else{
			response.setStatus(false);
		}
		
		return response;
	}
	
	@RequestMapping(value="/showExamTimeTable",method = RequestMethod.GET)
	public String showExamTimeTable(Model model){
		
		return "showExamTimeTable";
	}
	
	
	@RequestMapping(value="/getExamTimeTableData",method = RequestMethod.GET)
	public @ResponseBody JqGridInfo<ExamTimeTableData> getExamTimeTableData(Model model){
		
		System.out.println("getExamTimeTableData");
		
		JqGridInfo<ExamTimeTableData> jqGridData = homeService.getJqGridDataForExamTimeTable();
		
		return jqGridData;
	}

	@RequestMapping(value="/saveExamTimeTable",method = RequestMethod.POST)
	public String saveExamTimeTable(Model model,HttpServletRequest request){
		
		Map<String,String> requestMap =RequestUtil.INSTANCE.dumpRequestScope(request);
		homeService.saveExamTimeTable(requestMap);
		
		return "showExamTimeTable";
	}
	
	
	

}
