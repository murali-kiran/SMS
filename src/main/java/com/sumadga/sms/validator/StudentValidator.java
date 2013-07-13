package com.sumadga.sms.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.sumadga.sms.model.StudentForm;


@Component
public class StudentValidator {
	
	@Autowired
	private StudentDetailsSaveValidator detailsSaveValidator;
	
	public List<Errors> validateStudentSpecifyDetails(StudentForm studentForm){
		
		List<Errors> errorsList = new ArrayList<Errors>();
		Errors studentErrors = new BeanPropertyBindingResult(studentForm, "studentInfoVO");
		ValidationUtils.invokeValidator(detailsSaveValidator, studentForm, studentErrors);
		errorsList.add(studentErrors);
		return errorsList;
		
	}

	

}
