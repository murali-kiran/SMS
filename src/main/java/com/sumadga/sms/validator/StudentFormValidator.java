package com.sumadga.sms.validator;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sumadga.sms.model.StudentForm;

@Component
public class StudentFormValidator extends GenericValidations implements Validator{
	
	private static final Logger logger = Logger.getLogger(StudentFormValidator.class);

	public boolean supports(Class clazz) {
		return StudentForm.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors error) {
		
		StudentForm studentForm = (StudentForm)target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(error,"name","name", "* Name is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(error,"surName","surName", "* Surname is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(error,"dateOfBirth","dateOfBirth", "* Dob is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(error,"isPhysicallyChallenged","isPhysicallyChallenged", "* PhysicallyChallenged is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(error,"description","description", "* Description is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(error,"fatherName","fatherName", "* Father name is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(error,"fatherDesignation","fatherDesignation", "* Father designation is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(error,"motherName","motherName", "* Mother Name is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(error,"motherDesignation","motherDesignation", "* Mother designation is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(error,"gaurdian","gaurdian", "* Gaurdian is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(error,"address1","address1", "* Address is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(error,"address2","address2", "* Address is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(error,"pincode1","pincode1", "* Pincode is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(error,"pincode2","pincode2", "* Pincode is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(error,"state1","state1", "* State is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(error,"state2","state2", "* State is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(error,"district1","district1", "* District is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(error,"district2","district2", "* District is required");
		
			
			if((!pinCodeValidator(studentForm.getPincode1()))&&(studentForm.getPincode1().trim().length()>0)){
				
				error.rejectValue("pincode1", "pincode1","* Please Enter valid pincode");
			}
			
			if((!pinCodeValidator(studentForm.getPincode2()))&&(studentForm.getPincode2().trim().length()>0)){
				
				error.rejectValue("pincode2", "pincode2","* Please Enter valid pincode");
			}
			
		
		
	}

}
