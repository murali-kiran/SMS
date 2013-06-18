package com.sumadga.sms.model;

import java.util.List;

public class ClassForm {
	
	private String className;
	private int  sectionCount;
	private int  subjectCount;
	private String creationTime;
	private List<String> section;
	private List<String> subject;		
		
	public List<String> getSection() {
		return section;
	}
	public void setSection(List<String> section) {
		this.section = section;
	}
	public List<String> getSubject() {
		return subject;
	}
	public void setSubject(List<String> subject) {
		this.subject = subject;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public int getSectionCount() {
		return sectionCount;
	}
	public void setSectionCount(int sectionCount) {
		this.sectionCount = sectionCount;
	}
	public String getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}
	public int getSubjectCount() {
		return subjectCount;
	}
	public void setSubjectCount(int subjectCount) {
		this.subjectCount = subjectCount;
	}
	
	

}
