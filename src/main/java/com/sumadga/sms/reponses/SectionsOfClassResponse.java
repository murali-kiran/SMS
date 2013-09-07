package com.sumadga.sms.reponses;

import java.util.List;

import com.sumadga.sms.dto.TeachingStaffSubject;

public class SectionsOfClassResponse extends GenericJsonResponse {
	
	private List<Integer> classSectionIds;

	public List<Integer> getClassSectionIds() {
		return classSectionIds;
	}

	public void setClassSectionIds(List<Integer> classSectionIds) {
		this.classSectionIds = classSectionIds;
	}
	
	

}
