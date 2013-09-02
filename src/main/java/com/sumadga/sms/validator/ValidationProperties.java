package com.sumadga.sms.validator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ValidationProperties {
	
	@Value("${name}") 
	private String name;
	
	@Value("${surName}") 
	private  String surName;
	
	@Value("${dateOfBirth}") 
	private  String dateOfBirth;
	
	@Value("${isPhysicallyChallenged}") 
	private  String isPhysicallyChallenged;
	
	@Value("${description}") 
	private  String description;
	
	@Value("${fatherName}") 
	private  String fatherName;
	
	@Value("${fatherDesignation}") 
	private  String fatherDesignation;
	
	@Value("${motherName}") 
	private  String motherName;
	
	@Value("${motherDesignation}") 
	private  String motherDesignation;
	
	@Value("${gaurdian}") 
	private  String gaurdian;
	
	@Value("${address1}") 
	private  String address1;
	
	@Value("${address2}") 
	private  String address2;
	
	@Value("${pincode1}") 
	private  String pincode1;
	
	@Value("${pincode2}") 
	private  String pincode2;
	
	@Value("${state1}") 
	private  String state1;
	
	@Value("${state2}") 
	private  String state2;
	
	@Value("${district1}") 
	private  String district1;
	
	@Value("${district2}") 
	private  String district2;
	
	@Value("${subjectAlreadyExist}") 
	private  String subjectAlreadyExist;
	
	@Value("${examTypeAlreadyExist}")
	private String examTypeAlreadyExist;
	
	@Value("${examTypeSaveSuccess}")
	private String examTypeSaveSuccess;
	
	@Value("${examTimeTableExist}")
	private String examTimeTableExist;
	
	
	public String getExamTimeTableExist() {
		return examTimeTableExist;
	}
	public void setExamTimeTableExist(String examTimeTableExist) {
		this.examTimeTableExist = examTimeTableExist;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getIsPhysicallyChallenged() {
		return isPhysicallyChallenged;
	}
	public void setIsPhysicallyChallenged(String isPhysicallyChallenged) {
		this.isPhysicallyChallenged = isPhysicallyChallenged;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getFatherDesignation() {
		return fatherDesignation;
	}
	public void setFatherDesignation(String fatherDesignation) {
		this.fatherDesignation = fatherDesignation;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public String getMotherDesignation() {
		return motherDesignation;
	}
	public void setMotherDesignation(String motherDesignation) {
		this.motherDesignation = motherDesignation;
	}
	public String getGaurdian() {
		return gaurdian;
	}
	public void setGaurdian(String gaurdian) {
		this.gaurdian = gaurdian;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getPincode1() {
		return pincode1;
	}
	public void setPincode1(String pincode1) {
		this.pincode1 = pincode1;
	}
	public String getPincode2() {
		return pincode2;
	}
	public void setPincode2(String pincode2) {
		this.pincode2 = pincode2;
	}
	public String getState1() {
		return state1;
	}
	public void setState1(String state1) {
		this.state1 = state1;
	}
	public String getState2() {
		return state2;
	}
	public void setState2(String state2) {
		this.state2 = state2;
	}
	public String getDistrict1() {
		return district1;
	}
	public void setDistrict1(String district1) {
		this.district1 = district1;
	}
	public String getDistrict2() {
		return district2;
	}
	public void setDistrict2(String district2) {
		this.district2 = district2;
	}
	public String getSubjectAlreadyExist() {
		return subjectAlreadyExist;
	}
	public void setSubjectAlreadyExist(String subjectAlreadyExist) {
		this.subjectAlreadyExist = subjectAlreadyExist;
	}
	public String getExamTypeAlreadyExist() {
		return examTypeAlreadyExist;
	}
	public void setExamTypeAlreadyExist(String examTypeAlreadyExist) {
		this.examTypeAlreadyExist = examTypeAlreadyExist;
	}
	public String getExamTypeSaveSuccess() {
		return examTypeSaveSuccess;
	}
	public void setExamTypeSaveSuccess(String examTypeSaveSuccess) {
		this.examTypeSaveSuccess = examTypeSaveSuccess;
	}
	
	
}
