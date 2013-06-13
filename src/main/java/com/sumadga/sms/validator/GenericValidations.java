package com.sumadga.sms.validator;

import java.util.regex.Pattern;

public class GenericValidations {
	
	public static boolean emailValidator(String name) {
		return Pattern.compile("[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})").matcher(name.toLowerCase()).matches();
		}
	
	public static boolean pinCodeValidator(String name) {
		return Pattern.compile("[0-9]{6}").matcher(name).matches();
		}
	
	public static boolean phoneNumberValidator(String name) {
		return Pattern.compile("^(0|94)\\d{9,10}$").matcher(name).matches();
		}

}