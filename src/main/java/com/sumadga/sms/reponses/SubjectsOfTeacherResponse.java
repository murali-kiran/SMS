package com.sumadga.sms.reponses;

import java.util.List;

import com.sumadga.sms.dto.TeachingStaffSubject;

public class SubjectsOfTeacherResponse extends GenericJsonResponse {
	
	private List<Integer> teachingStaffSubjectIds;

	public List<Integer> getTeachingStaffSubjectIds() {
		return teachingStaffSubjectIds;
	}

	public void setTeachingStaffSubjectIds(List<Integer> teachingStaffSubjectIds) {
		this.teachingStaffSubjectIds = teachingStaffSubjectIds;
	}

}
