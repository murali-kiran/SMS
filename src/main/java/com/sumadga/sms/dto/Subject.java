package com.sumadga.sms.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Subjects database table.
 * 
 */
@Entity
@Table(name="Subjects")
public class Subject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int subjectId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTime;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedTime;

	private String subjectName;

	//bi-directional many-to-one association to ClassSubject
	@OneToMany(mappedBy="subject")
	private List<ClassSubject> classSubjects;

	//bi-directional many-to-one association to SubjectTimeTable
	@OneToMany(mappedBy="subject")
	private List<SubjectTimeTable> subjectTimeTables;

	//bi-directional many-to-one association to TeachingStaffSubject
	@OneToMany(mappedBy="subject")
	private List<TeachingStaffSubject> teachingStaffSubjects;

	public Subject() {
	}

	public int getSubjectId() {
		return this.subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public Date getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getModifiedTime() {
		return this.modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public String getSubjectName() {
		return this.subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public List<ClassSubject> getClassSubjects() {
		return this.classSubjects;
	}

	public void setClassSubjects(List<ClassSubject> classSubjects) {
		this.classSubjects = classSubjects;
	}

	public List<SubjectTimeTable> getSubjectTimeTables() {
		return this.subjectTimeTables;
	}

	public void setSubjectTimeTables(List<SubjectTimeTable> subjectTimeTables) {
		this.subjectTimeTables = subjectTimeTables;
	}

	public List<TeachingStaffSubject> getTeachingStaffSubjects() {
		return this.teachingStaffSubjects;
	}

	public void setTeachingStaffSubjects(List<TeachingStaffSubject> teachingStaffSubjects) {
		this.teachingStaffSubjects = teachingStaffSubjects;
	}

}