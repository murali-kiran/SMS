package com.sumadga.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sumadga.sms.model.StudentForm;
import com.sumadga.sms.service.StudentService;
import com.sumadga.sms.validator.StudentFormValidator;

@Controller
@Scope("request")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private StudentFormValidator studentFormValidator;
	
	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public String showNewStudentForm(Model model){
		
		model.addAttribute("student", new StudentForm());
		return "studentForm";
	}
	
	@RequestMapping(value = "/saveStudentDetails", method = RequestMethod.POST)
	public String saveStudentDetails(Model model,@ModelAttribute("student") StudentForm studentForm,BindingResult result){
		
		studentFormValidator.validate(studentForm, result);
		if(result.hasErrors()){
			model.addAttribute("student", studentForm);
			model.addAttribute("error", true);
		}else{
     	    studentService.saveStudentDetails(studentForm);
		}
		return "studentForm";
	}
	
}
