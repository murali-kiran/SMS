package com.sumadga.sms.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sumadga.sms.model.StudentForm;
import com.sumadga.sms.utils.CommonUtils;

@Component
public class StudentDetailsSaveValidator extends GenericValidations implements Validator{

	@Override
	public boolean supports(Class clazz ) {
		return StudentForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		/*		ValidationUtils.rejectIfEmptyOrWhitespace(error,"name","name", "* Name is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(error,"surName","surName", "* Surname is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(error,"dateOfBirth","dateOfBirth", "* Dob is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(error,"isPhysicallyChallenged","isPhysicallyChallenged", "* PhysicallyChallenged is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(error,"description","description", "* Description is required");			
		 */	

		StudentForm studentForm = (StudentForm)target;

		if(CommonUtils.isEmpty(studentForm.getName())){
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name","name", "* Name is required");
		}

		if(CommonUtils.isEmpty(studentForm.getSurName())){
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,"surName","surName", "* Surname is required");
		}

		if(CommonUtils.isEmpty(studentForm.getDateOfBirth())){
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,"dateOfBirth","dateOfBirth", "* Dob is required");
		}

		if(CommonUtils.isEmpty(studentForm.getIsPhysicallyChallenged()+"")){
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,"isPhysicallyChallenged","isPhysicallyChallenged", "* PhysicallyChallenged is required");
		}

		if(CommonUtils.isEmpty(studentForm.getDescription())){
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,"description","description", "* Description is required");
		}

	}

}
