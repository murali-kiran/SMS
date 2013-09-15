package com.sumadga.sms.reponses;

import java.util.List;

import com.sumadga.sms.model.GenericBean;

public class SectionsOfClassResponse extends GenericJsonResponse {
	
	private List<Integer> classSectionIds;
	private List<GenericBean> classSections;

	public List<Integer> getClassSectionIds() {
		return classSectionIds;
	}

	public void setClassSectionIds(List<Integer> classSectionIds) {
		this.classSectionIds = classSectionIds;
	}

	public List<GenericBean> getClassSections() {
		return classSections;
	}

	public void setClassSections(List<GenericBean> classSections) {
		this.classSections = classSections;
	}

	
	
}
