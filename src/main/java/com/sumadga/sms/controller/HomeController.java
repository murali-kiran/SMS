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
import com.sumadga.sms.dto.Designations;
import com.sumadga.sms.dto.StudentClass;
import com.sumadga.sms.model.ClassForm;
import com.sumadga.sms.reponses.GenericJsonResponse;
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
	
	
	

}
