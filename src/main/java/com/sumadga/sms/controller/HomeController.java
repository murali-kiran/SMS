package com.sumadga.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.sumadga.sms.dto.StudentClass;
import com.sumadga.sms.model.ClassForm;
import com.sumadga.sms.service.ClassesService;

@Controller
public class HomeController {
	
	@Autowired
	private ClassesService classesService;
	
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
	
	/*@RequestMapping(value="/getSectionDetailsOfClass",method = RequestMethod.GET)
	public String classesInfo(Model model){
		
		List<StudentClass> classes = classesService.getClassInfo();		
		model.addAttribute("classes", classes);
//		model.addAttribute("classForm", new ClassForm());
		return "classInfo";
	}*/
	
	@RequestMapping(value="/saveClassDetails",method = RequestMethod.POST)
	public String saveClassDetails(Model model,@ModelAttribute("classForm") ClassForm classForm){
        
		return "classInfo";
	}
	

}
