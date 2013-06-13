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
		
		ValidationUtils.rejectIfEmptyOrWhitespace(error,"name","required.name", "* Name is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(error,"surName","required.surName", "* Surname is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(error,"dateOfBirth","required.dateOfBirth", "* Dob is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(error,"isPhysicallyChallenged","required.isPhysicallyChallenged", "* PhysicallyChallenged is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(error,"description","required.description", "* Description is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(error,"fatherName","required.fatherName", "* Father name is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(error,"fatherDesignation","required.fatherDesignation", "* Father designation is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(error,"motherName","required.motherName", "* Mother Name is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(error,"motherDesignation","required.motherDesignation", "* Mother designation is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(error,"gaurdian","required.gaurdian", "* Gaurdian is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(error,"address1","required.address1", "* Address is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(error,"address2","required.address2", "* Address is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(error,"pincode1","required.pincode1", "* Pincode is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(error,"pincode2","required.pincode2", "* Pincode is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(error,"state1","required.state1", "* State is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(error,"state2","required.state2", "* State is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(error,"district1","required.district1", "* District is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(error,"district2","required.district2", "* District is required");
		
			
			if((!pinCodeValidator(studentForm.getPincode1()))&&(studentForm.getPincode1().trim().length()>0)){
				
				error.rejectValue("pincode1", "required.pincode1","* Please Enter valid pincode");
			}
			
			if((!pinCodeValidator(studentForm.getPincode2()))&&(studentForm.getPincode2().trim().length()>0)){
				
				error.rejectValue("pincode2", "required.pincode2","* Please Enter valid pincode");
			}
			
		
		
	}

}
