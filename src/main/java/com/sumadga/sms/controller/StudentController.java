package com.sumadga.sms.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sumadga.sms.model.StudentForm;
import com.sumadga.sms.reponses.GenericJsonResponse;
import com.sumadga.sms.service.StudentService;
import com.sumadga.sms.utils.RequestUtil;
import com.sumadga.sms.validator.StudentDetailsSaveValidator;
import com.sumadga.sms.validator.StudentValidator;

@Controller
@Scope("request")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private StudentValidator studentValidator;
	
	@Autowired
	private StudentDetailsSaveValidator studentDetailsSaveValidator;
	
	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public String editStudentForm(Model model){
		
		model.addAttribute("student", new StudentForm());
//		model.addAttribute("studentId",-1);
		return "studentForm";
	}
	
	@RequestMapping(value = "/newStudent", method = RequestMethod.GET)
	public String newStudentForm(Model model){
		
		model.addAttribute("student", new StudentForm());
		return "pages/newStudent";
		
//		return "newStudent";
	}
	
	
	@RequestMapping(value = "/saveStudentDetails", method = RequestMethod.POST)
	public String  saveStudentDetails(Model model,HttpServletRequest request)
	{
		
		Map<String,String> requestMap =RequestUtil.INSTANCE.dumpRequestScope(request);
						
		studentService.saveStudentDetails(requestMap);
				
		return "";
	}
	
	
	
	
	/*@RequestMapping(value = "/saveStudentDetails", method = RequestMethod.POST)
	public @ResponseBody GenericJsonResponse saveStudentDetails(Model model,
			@RequestParam(value = "studentId",required = false) Integer studentId,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "surName", required = false) String surName,
			@RequestParam(value = "dateOfBirth", required = false) String dateOfBirth,
			@RequestParam(value = "joiningDate", required = false) String joiningDate,
			@RequestParam(value = "isPhysicallyChallenged", required = false) Integer isPhysicallyChallenged,
			@RequestParam(value = "description", required = false) String description,
			HttpServletRequest request)
	{
		
		
		GenericJsonResponse response = new GenericJsonResponse();
		
		System.out.println(request.getParameter("isPhysicallyChallenged"));
		StudentForm studentForm = new StudentForm();
		studentForm.setName(surName);
		studentForm.setSurName(surName);
		studentForm.setDateOfBirth(dateOfBirth);
		studentForm.setJoiningDate(joiningDate);
		studentForm.setIsPhysicallyChallenged(isPhysicallyChallenged==1?true:false);
		studentForm.setDescription(description);
		studentForm.setStudentId(studentId);
		
		
		List<Errors> errors = studentValidator.validateStudentSpecifyDetails(studentForm);
		
		for(Errors error : errors){
			System.out.println(error);
		}
		
		if(errors.hasErrors()){
			model.addAttribute("student", studentForm);
			model.addAttribute("error", true);
		}else{
     	//    studentService.saveStudentDetails(studentForm);
		    studentService.saveStudentSpecificDetails(studentForm);
		}
		
		
		if(studentService.saveStudentSpecificDetails(studentForm)){
			response.setStatus("success");
		}
		
		return response;
	}*/
	
	/*@RequestMapping(value = "/saveStudentParentDetails", method = RequestMethod.GET)
	public String saveStudentParentDetails(Model model,@ModelAttribute("student") StudentForm studentForm,BindingResult result){
		
		studentFormValidator.validate(studentForm, result);
		if(result.hasErrors()){
			model.addAttribute("student", studentForm);
			model.addAttribute("error", true);
		}else{
     	    studentService.saveStudentDetails(studentForm);
		}
		return "studentForm";
	}
	
	@RequestMapping(value = "/saveStudentPermanentAddress", method = RequestMethod.GET)
	public String saveStudentPermanentAddress(@ModelAttribute("student") StudentForm studentForm,BindingResult result,Model model){
		
		studentFormValidator.validate(studentForm, result);
		if(result.hasErrors()){
			model.addAttribute("student", studentForm);
			model.addAttribute("error", true);
		}else{
     	    studentService.saveStudentDetails(studentForm);
		}
		return "studentForm";
	}
	
	@RequestMapping(value = "/saveStudentTemporaryAddress", method = RequestMethod.GET)
	public String saveStudentTemporaryAddress(Model model,
			BindingResult result){
		
		StudentForm studentForm = new StudentForm();
		studentFormValidator.validate(studentForm, result);
		if(result.hasErrors()){
			model.addAttribute("student", studentForm);
			model.addAttribute("error", true);
		}else{
     	    studentService.saveStudentDetails(studentForm);
		}
		return "studentForm";
	}*/
	
}
